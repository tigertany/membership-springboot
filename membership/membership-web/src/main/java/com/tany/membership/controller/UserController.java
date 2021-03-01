package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.MyPage;
import com.tany.membership.common.PagedResult;
import com.tany.membership.dto.SaveUserAndRoles;
import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUser;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysUserRoleService;
import com.tany.membership.service.ISysUserService;
import com.tany.membership.vo.UserWithRole;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Anonymous
@RequestMapping(Constant.BASE_API_PATH +"/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysUserRoleService userRoleService;

    @GetMapping
    public JSONResult getUserList(Long pageIndex,Long pageSize,String sortColumn,String sortMethod,
                              @RequestParam(required = false) LinkedHashMap<String,Object> search)
    {
        return JSONResult.ok(userService.query(pageIndex,pageSize,sortColumn,sortMethod,search));
    /*
        Page<UserWithRole> page = new Page<>(pageIndex,3); //查询第一页，查询1条数据
        //page.setSearchCount(false);

        QueryWrapper<UserWithRole> wrapper = new QueryWrapper<>();
        //设置查询条件
        for (Map.Entry<String, Object> entry : search.entrySet()) {

            if (staticParams.contains(entry.getKey())) continue;
            wrapper.like(entry.getKey(),entry.getValue());
        }


        //wrapper.like("roles_name","员");
        wrapper.eq("deleted",0);

        if (StringUtils.isNotBlank(orderAsc))
        {
            page.addOrder(OrderItem.asc(orderAsc));
        }
        if (StringUtils.isNotBlank(orderDesc))
        {
            page.addOrder(OrderItem.desc(orderDesc));
        }


        IPage<UserWithRole> iPage = userService.getUserList(page, wrapper); //userService.page(page, wrapper);
*/
//        iPage.setTotal(count);
//        System.out.println("数据总条数： " + iPage.getTotal());
//        System.out.println("数据总页数： " + iPage.getPages());
//        System.out.println("当前页数： " + iPage.getCurrent());


//        List<SIMPLE_BUSS_INFO> newList = new ArrayList<>();
//
//        for (BUSS_INFO originObj : iPage.getRecords()) {
//            newList.add(CommonUtils.entityMapping(SIMPLE_BUSS_INFO.class, originObj));
//        }



    }

    @GetMapping("/{id}")
    public JSONResult getUser(@RequestAttribute(value = Constant.CURUSER_ID,required = false) String curUserId,@PathVariable long id)
    {
        JSONResult jsonResult = new JSONResult();
/*
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();


        queryWrapper.eq(SysUser::getId, id);
        queryWrapper.eq(SysUser::getDeleted, 0);
        //queryWrapper.eq("CREATER_ID", userId);

        SysUser entity = userService.getOne(queryWrapper,false);
*/

        UserWithRole userWithRole = userService.queryById(id);
        if(userWithRole!=null)
        {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setData(userWithRole);
            return jsonResult;
        }
        else
        {
            return JSONResult.error("无此用户！");
        }
    }

    @DeleteMapping("/{ids}")//url:delete/1,2,3
    public JSONResult delUser(@RequestAttribute(value = Constant.CURUSER_ID,required = false) String curUserId,@PathVariable Long[] ids)
    {
        JSONResult jsonResult = new JSONResult();

        if(userService.delete(curUserId,ids))
        {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("删除成功!");
            return jsonResult;
        }
        else
        {
            return JSONResult.error("删除失败！");
        }
    }

    @PostMapping("/save")//@RequestBody SaveUserAndRoles saveUserAndRoles
    public JSONResult save(@RequestAttribute(value = Constant.CURUSER_ID,required = false) String curUserId,
                           @RequestBody SaveUserAndRoles saveUserAndRoles) {
        JSONResult jsonResult = new JSONResult();
        //logger.info(saveUserAndRoles.toString());

        if (userService.save(curUserId,saveUserAndRoles)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("保存成功！");

        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("保存失败！");
        }
        return jsonResult;

    }

    @PostMapping("/setrole")
    public JSONResult setRole(@RequestAttribute(Constant.CURUSER_ID) String curUserId, List<SysUserRole> list) {
        JSONResult jsonResult = new JSONResult();
        //logger.info(user.toString());


        if (userRoleService.saveBatch(list)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("保存成功！");
        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("保存失败！");
        }


        return jsonResult;

    }
}

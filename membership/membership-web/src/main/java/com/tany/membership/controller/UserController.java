package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.PagedResult;
import com.tany.membership.entity.SysUser;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysUserRoleService;
import com.tany.membership.service.ISysUserService;
import com.tany.membership.vo.UserWithRole;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Anonymous
@RequestMapping(Constant.BASE_API_PATH +"/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysUserRoleService userRoleService;

    @GetMapping("/")
    public JSONResult getUserList(@RequestParam(Constant.CURUSER_ID) String curUserId,
                              @PathParam("index") Long pageIndex,
                              @PathParam("search") String search,
                              @PathParam("asc") String orderAsc,
                              @PathParam("desc") String orderDesc)
    {

        if (pageIndex==null || pageIndex==0) {
            pageIndex =1l;
        }


        Page<UserWithRole> page = new Page<>(pageIndex,3); //查询第一页，查询1条数据


        QueryWrapper<UserWithRole> wrapper = new QueryWrapper<>();

        //设置查询条件
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("account",search);
        }

        wrapper.like("roles_name","员");
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
//        System.out.println("数据总条数： " + iPage.getTotal());
//        System.out.println("数据总页数： " + iPage.getPages());
//        System.out.println("当前页数： " + iPage.getCurrent());


//        List<SIMPLE_BUSS_INFO> newList = new ArrayList<>();
//
//        for (BUSS_INFO originObj : iPage.getRecords()) {
//            newList.add(CommonUtils.entityMapping(SIMPLE_BUSS_INFO.class, originObj));
//        }

        PagedResult pagedResult = new PagedResult();
        pagedResult.setTotalPage(iPage.getPages());
        pagedResult.setTotalRecords(iPage.getTotal());
        pagedResult.setCurrentPage(iPage.getCurrent());
        pagedResult.setRows(iPage.getRecords());


        return JSONResult.ok(pagedResult);
    }

    @GetMapping("/{id}")
    public JSONResult getUser(@RequestParam(Constant.CURUSER_ID) String curUserId,@PathVariable String id)
    {
        JSONResult jsonResult = new JSONResult();

        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();


        queryWrapper.eq(SysUser::getId, id);
        queryWrapper.eq(SysUser::getDeleted, 0);
        //queryWrapper.eq("CREATER_ID", userId);

        SysUser entity = userService.getOne(queryWrapper,false);

        if(entity!=null)
        {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setData(entity);
            return jsonResult;
        }
        else
        {
            return JSONResult.error("无此用户！");
        }
    }

    @GetMapping("/delete/{ids}")//url:delete/1,2,3
    public JSONResult delUser(@RequestParam(Constant.CURUSER_ID) String curUserId,@PathVariable Integer[] ids)
    {
        JSONResult jsonResult = new JSONResult();

        List<SysUser> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++)
        {
            SysUser user = new SysUser();
            user.setId(ids[i]);
            user.setDeleted(1);
            user.setDeletedDate(new Date());
            list.add(user);
        }



        if(userService.updateBatchById(list))
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

    @PostMapping("/save")
    public JSONResult save(@RequestParam(Constant.CURUSER_ID) String curUserId,@Validated @RequestBody SysUser user) {
        JSONResult jsonResult = new JSONResult();
        //logger.info(user.toString());



        if (user.getId()==null || user.getId()==0) {
            jsonResult.setMsg("保存失败，未传递主键！");

        }
        else
        {
            user.setRecordDate(new Date());
            user.setRecorder(curUserId);
            if (userService.saveOrUpdate(user)) {
                jsonResult.setStatus(HttpStatus.OK);
                jsonResult.setMsg("保存成功！");
                System.out.println(user.getId());
            } else {
                jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                jsonResult.setMsg("保存失败！");
            }

        }

        return jsonResult;

    }

    @PostMapping("/setrole")
    public JSONResult setRole(@RequestParam(Constant.CURUSER_ID) String curUserId, List<SysUserRole> list) {
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

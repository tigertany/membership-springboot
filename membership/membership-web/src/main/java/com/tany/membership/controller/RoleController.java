package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.PagedResult;
import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysRoleService;
import com.tany.membership.service.ISysUserRoleService;
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
@RequestMapping("/role")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysUserRoleService userRoleService;

    @GetMapping("/")
    public JSONResult getRoleList(@ModelAttribute(Constant.USER_ID) String userId,
                                  @PathParam("index") Long pageIndex,
                                  @PathParam("search") String search,
                                  @PathParam("asc") String orderAsc,
                                  @PathParam("desc") String orderDesc)
    {

        if (pageIndex==null || pageIndex==0) {
            pageIndex =1l;
        }


        Page<SysRole> page = new Page<>(pageIndex,3); //查询第一页，查询1条数据


        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        //设置查询条件
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("name",search);
        }


        wrapper.eq("deleted",0);

        if (StringUtils.isNotBlank(orderAsc))
        {
            page.addOrder(OrderItem.asc(orderAsc));
        }
        if (StringUtils.isNotBlank(orderDesc))
        {
            page.addOrder(OrderItem.desc(orderDesc));
        }


        IPage<SysRole> iPage = roleService.page(page, wrapper); //userService.page(page, wrapper);
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
    public JSONResult getRole(@ModelAttribute(Constant.USER_ID) String userId,@PathVariable String id)
    {
        JSONResult jsonResult = new JSONResult();

        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();


        queryWrapper.eq("id", id);
        queryWrapper.eq("deleted", 0);


        SysRole entity = roleService.getOne(queryWrapper,false);

        if(entity!=null)
        {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setData(entity);
            return jsonResult;
        }
        else
        {
            return JSONResult.error("无此角色！");
        }

    }
    @GetMapping("/delete/{ids}")
    public JSONResult delRole(@ModelAttribute(Constant.USER_ID) String userId,@PathVariable Integer[] ids)
    {
        JSONResult jsonResult = new JSONResult();

        List<SysRole> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++)
        {
            SysRole role = new SysRole();
            role.setId(ids[i]);
            role.setDeleted(1);
            role.setDeletedDate(new Date());
            list.add(role);
        }

        if(roleService.updateBatchById(list))
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
    @PostMapping("save")
    public JSONResult save(@Validated @RequestBody SysRole role, @ModelAttribute(Constant.USER_ID) String userId)
    {
        JSONResult jsonResult = new JSONResult();
        //logger.info(user.toString());

        if (role.getId()==null || role.getId()==0) {
            jsonResult.setMsg("保存失败，未传递主键！");

        }
        else
        {
            role.setRecordDate(new Date());
            role.setRecorder(userId);
            if (roleService.saveOrUpdate(role)) {
                jsonResult.setStatus(HttpStatus.OK);
                jsonResult.setMsg("保存成功！");
                System.out.println(role.getId());
            } else {
                jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                jsonResult.setMsg("保存失败！");
            }

        }

        return jsonResult;

    }
    @PostMapping("setUser")
    public JSONResult setUser(@ModelAttribute(Constant.USER_ID) String currentUserId, List<SysUserRole> list)
    {
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

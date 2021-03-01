package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.PagedResult;
import com.tany.membership.entity.SysPermissionRelation;
import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysPermissionRelationService;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.service.ISysRoleService;
import com.tany.membership.service.ISysUserRoleService;
import com.tany.membership.vo.PermissionWithChecked;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@Anonymous
@RequestMapping(Constant.BASE_API_PATH+"/role")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private ISysPermissionService permissionService;
    @Autowired
    private ISysPermissionRelationService permissionRelationService;

    @GetMapping
    public JSONResult getRoleList(Long pageIndex,Long pageSize,String sortColumn,String sortMethod,
                                  @RequestParam(required = false) LinkedHashMap<String,Object> search)
    {
        List<String> staticParams = Arrays.asList("pageIndex","pageSize","sortColumn","sortMethod");


        Page<SysRole> page = new Page<>(pageIndex,pageSize); //查询第一页，查询1条数据


        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        //设置查询条件
        for (Map.Entry<String, Object> entry : search.entrySet()) {

            if (staticParams.contains(entry.getKey())) continue;
            wrapper.like(entry.getKey(),entry.getValue());
        }


        wrapper.eq("deleted",0);

        if ("asc".equalsIgnoreCase(sortMethod))
        {
            page.addOrder(OrderItem.asc(sortColumn));
        }
        if ("desc".equalsIgnoreCase(sortMethod))
        {
            page.addOrder(OrderItem.desc(sortColumn));
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
    public JSONResult getRole(@PathVariable("id") String id)
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

    @DeleteMapping("/{ids}")
    public JSONResult delRole(@RequestAttribute(Constant.CURUSER_ID) String curUserId,@PathVariable("ids") Integer[] ids)
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
    @PostMapping
    public JSONResult save(@RequestAttribute(value = Constant.CURUSER_ID) String curUserId,
                           @Validated @RequestBody SysRole role)
    {
        JSONResult jsonResult = new JSONResult();
        //logger.info(role.toString());


        role.setRecordDate(new Date());
        role.setRecorder(curUserId);
        if (roleService.saveOrUpdate(role)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("保存成功！");

        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("保存失败！");
        }



        return jsonResult;

    }
    @PostMapping("setUser")
    public JSONResult setUser(@RequestAttribute(Constant.CURUSER_ID) String curUserId, List<SysUserRole> list)
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
    @PostMapping("setPermission")
    public JSONResult setPermission(@RequestAttribute(value = Constant.CURUSER_ID,required = false) String curUserId,@RequestBody ArrayList<SysPermissionRelation> sysPermissionRelations)
    {
        JSONResult jsonResult = new JSONResult();

        if (sysPermissionRelations!=null&&sysPermissionRelations.size()>0)
        {
            QueryWrapper<SysPermissionRelation> wrapper = new QueryWrapper<>();
            wrapper.eq("type",1);
            wrapper.eq("share_id",sysPermissionRelations.get(0).getShareId());
            permissionRelationService.remove(wrapper);

            if (permissionRelationService.saveBatch(sysPermissionRelations)) {
                jsonResult.setStatus(HttpStatus.OK);
                jsonResult.setMsg("保存成功！");
            } else {
                jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                jsonResult.setMsg("保存失败！");
            }
        }

        return jsonResult;

    }
    @GetMapping("/{id}/permission")
    public JSONResult getPermissionByRole(@RequestAttribute(value = Constant.CURUSER_ID,required = false) String curUserId,@PathVariable("id") long roleId)
    {
        JSONResult jsonResult = new JSONResult();
        List<PermissionWithChecked> list = permissionService.getPermissionByRole(roleId);

        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(list);
        return jsonResult;



    }
}

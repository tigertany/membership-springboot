package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.entity.SysPermissionRelation;
import com.tany.membership.service.ISysPermissionRelationService;
import com.tany.membership.service.ISysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//@Anonymous
@RequestMapping(Constant.BASE_API_PATH+"/permission")
public class PermissionController {
    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private ISysPermissionService permissionService;
    @Autowired
    private ISysPermissionRelationService relationService;

    @GetMapping
    public JSONResult getPermission()
    {
        JSONResult jsonResult = new JSONResult();

        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getPermissionList());
        return jsonResult;
    }

    @PostMapping
    public JSONResult savePermission(@RequestAttribute(value = Constant.CURUSER_ID,required = false) String curUserId,
                                     @RequestBody SysPermission sysPermission)
    {
        JSONResult jsonResult = new JSONResult();

        if (permissionService.saveOrUpdate(sysPermission)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("保存成功！");
        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("保存失败！");
        }

        return jsonResult;
    }

    @DeleteMapping
    public JSONResult delPermission(SysPermission permission){
        JSONResult jsonResult = new JSONResult();

        permission.setDeleted(1);
        permission.setDeletedDate(new Date());
        if (permissionService.save(permission)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("删除成功！");
        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("删除失败！");
        }

        return jsonResult;
    }

    @GetMapping("/byRole")
    public JSONResult getPermissionByRole(Long roleId)
    {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getPermissionByRole(roleId));
        return jsonResult;

    }

    @GetMapping("/byUser")
    public JSONResult getPermissionByUser(@RequestAttribute(Constant.CURUSER_ID) Long curUserId)
    {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getPermissionByUser(curUserId));
        return jsonResult;
    }


    @PostMapping("/saveRolePermission")
    public JSONResult saveRolePermission(@RequestAttribute(Constant.CURUSER_ID) Long curUserId,Long userId, List<SysPermissionRelation> list)
    {
        JSONResult jsonResult = new JSONResult();

        if (relationService.saveRolePermission(userId ,list)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("保存成功！");
        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("保存失败！");
        }

        return jsonResult;
    }



    @GetMapping("/getMenusByUser")
    public JSONResult getMenuByUser(@RequestAttribute(Constant.CURUSER_ID) Long curUserId)
    {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getMenusByUser(curUserId));
        return jsonResult;
    }
}

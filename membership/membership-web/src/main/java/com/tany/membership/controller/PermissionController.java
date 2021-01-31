package com.tany.membership.controller;

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

import java.util.List;

@RestController
@Anonymous
@RequestMapping("/permission")
public class PermissionController {
    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private ISysPermissionService permissionService;
    @Autowired
    private ISysPermissionRelationService relationService;

    @GetMapping("/byRole")
    public JSONResult getPermissionByRole(@ModelAttribute(Constant.USER_ID) String userId,Long roleId)
    {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getPermissionByRole(roleId));
        return jsonResult;

    }

    @GetMapping("/byUser")
    public JSONResult getPermissionByUser(@ModelAttribute(Constant.USER_ID) String curUserId,Long userId)
    {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getPermissionByUser(userId));
        return jsonResult;
    }


    @PostMapping("/saveRolePermission")
    public JSONResult saveRolePermission(@ModelAttribute(Constant.USER_ID) Long userId, List<SysPermissionRelation> list)
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

    @PostMapping("/save")
    public JSONResult savePermission(@ModelAttribute(Constant.USER_ID) String userId, List<SysPermission> list)
    {
        JSONResult jsonResult = new JSONResult();

        if (permissionService.saveBatch(list)) {
            jsonResult.setStatus(HttpStatus.OK);
            jsonResult.setMsg("保存成功！");
        } else {
            jsonResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            jsonResult.setMsg("保存失败！");
        }

        return jsonResult;
    }

    @GetMapping("/getmenusbyuser")
    public JSONResult getMenuByUser(Long userId)
    {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStatus(HttpStatus.OK);
        jsonResult.setData(permissionService.getMenusByUser(userId));
        return jsonResult;
    }
}

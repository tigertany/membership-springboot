package com.tany.membership.controller;

import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.service.ISysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@Anonymous
@RequestMapping(Constant.BASE_API_PATH)
public class PermissionController {
    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private ISysPermissionService permissionService;

    @GetMapping("/permissions")
    public JSONResult getPermissionList()
    {
        return JSONResult.success(permissionService.getPermissionList());
    }

    @PostMapping("/permission")
    public JSONResult savePermission(@RequestAttribute(value = Constant.CURUSER_ID,required = false) Long curUserId,
                                     @RequestBody SysPermission sysPermission)
    {
        if (permissionService.saveOrUpdate(sysPermission)) {
            return JSONResult.success("保存成功！");
        } else {
            return JSONResult.fail("保存失败！");
        }
    }

    @DeleteMapping("/permission")
    public JSONResult delPermission(@RequestAttribute(value = Constant.CURUSER_ID,required = false) Long curUserId,SysPermission permission){
        permission.setDeleted(true);

        if (permissionService.save(permission)) {
            return JSONResult.success("删除成功！");
        } else {
            return JSONResult.fail("删除失败！");
        }

    }

    /*@GetMapping("/permission/{roleId}")
    public JSONResult getPermissionByRole(@PathVariable("roleId") Long roleId)
    {
        return JSONResult.success(permissionService.getPermissionByRole(roleId));
    }*/



    /*
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
    }*/


}

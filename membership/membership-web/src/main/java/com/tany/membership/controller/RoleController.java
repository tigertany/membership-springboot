package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.entity.SysPermissionRelation;
import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysPermissionRelationService;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.service.ISysRoleService;
import com.tany.membership.service.ISysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
//@Anonymous
@RequestMapping(Constant.BASE_API_PATH)
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

    @GetMapping("/roles")
    public JSONResult getRoleList(Long pageIndex,Long pageSize,String sortColumn,String sortMethod,
                                  @RequestParam(required = false) Map<String,Object> search)
    {
        return JSONResult.success(roleService.query(pageIndex,pageSize,sortColumn,sortMethod,search));
    }

    @GetMapping("/role/{id}")
    public JSONResult getRole(@PathVariable("id") Long roleId)
    {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("id", roleId);
        queryWrapper.eq("deleted", 0);

        SysRole entity = roleService.getOne(queryWrapper,false);

        if(entity!=null)
        {
            return JSONResult.success(entity);
        }
        else
        {
            return JSONResult.fail("无此角色！");
        }
    }

    @DeleteMapping("/role/{ids}")
    public JSONResult delRole(@RequestAttribute(Constant.CURUSER_ID) Long curUserId,@PathVariable("ids") Long[] ids)
    {
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
            return JSONResult.success("删除成功!");
        }
        else
        {
            return JSONResult.fail("删除失败！");
        }
    }
    @PostMapping("/role")
    public JSONResult save(@RequestAttribute(value = Constant.CURUSER_ID) Long curUserId,
                           @Validated @RequestBody SysRole role)
    {
        //logger.info(role.toString());
        role.setCreateDate(new Date());
        role.setCreater(curUserId);
        if (roleService.saveOrUpdate(role)) {
            return JSONResult.success("保存成功！");

        } else {
            return JSONResult.fail("保存失败！");
        }
    }

    /**
     * 修改并保存角色下的用户
     * @param curUserId
     * @param list
     * @return
     */
    @PutMapping("/role/user")
    public JSONResult setUser(@RequestAttribute(Constant.CURUSER_ID) Long curUserId, List<SysUserRole> list)
    {
        //logger.info(user.toString());
        if (userRoleService.saveBatch(list)) {
            return JSONResult.success("保存成功！");
        } else {
            return JSONResult.fail("保存失败！");
        }
    }

    /**
     * 修改并保存某个角色的权限
     * @param curUserId
     * @param list
     * @return
     */
    @PutMapping("/role/permission")
    public JSONResult setPermission(@RequestAttribute(value = Constant.CURUSER_ID, required = false) Long curUserId, @RequestBody ArrayList<SysPermissionRelation> list) {
        if (permissionRelationService.setPermission(curUserId, list)) {
            return JSONResult.success("保存成功！");
        } else {
            return JSONResult.fail("保存失败！");
        }
    }

    /**
     * 获取某个角色的全部权限
     * @param roleId
     * @return
     */
    @GetMapping("/role/{id}/permissions")
    public JSONResult getPermissionByRole(@PathVariable("id") Long roleId)
    {
        return JSONResult.success(permissionService.getPermissionByRole(roleId));
    }
}

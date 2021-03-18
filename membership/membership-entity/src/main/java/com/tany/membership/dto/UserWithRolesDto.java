package com.tany.membership.dto;

import com.tany.membership.entity.SysUser;
import com.tany.membership.entity.SysUserRole;

import java.util.List;

public class UserWithRolesDto {
    private SysUser sysUser;
    private List<SysUserRole> sysUserRoleList;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<SysUserRole> getSysUserRoleList() {
        return sysUserRoleList;
    }

    public void setSysUserRoleList(List<SysUserRole> sysUserRoleList) {
        this.sysUserRoleList = sysUserRoleList;
    }
}

package com.tany.membership.dto;

import com.tany.membership.entity.SysDept;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUser;

import java.util.List;

public class UserProfile {
    private SysUser user;
    private List<SysRole> roles;
    private List<SysDept> depts;
    private List<SysPermission> permissions;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public List<SysDept> getDepts() {
        return depts;
    }

    public void setDepts(List<SysDept> depts) {
        this.depts = depts;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}

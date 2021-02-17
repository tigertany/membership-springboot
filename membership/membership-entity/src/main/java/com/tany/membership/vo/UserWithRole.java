package com.tany.membership.vo;

import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUser;

import java.util.List;

public class UserWithRole extends SysUser {

    private List<SysRole> roles;

    private String rolesName;

    private String rolesCode;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public void setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
    }
}

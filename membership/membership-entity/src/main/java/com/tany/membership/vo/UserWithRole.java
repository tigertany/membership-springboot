package com.tany.membership.vo;

import com.tany.membership.entity.SysUser;

public class UserWithRole extends SysUser {

    private String rolesName;

    private String rolesCode;

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

package com.tany.membership.vo;

import com.tany.membership.entity.SysPermission;

import java.util.List;

public class PermissionWithChecked extends SysPermission {
    private boolean checked;

    private List<PermissionWithChecked> children;

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<PermissionWithChecked> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionWithChecked> children) {
        this.children = children;
    }
}

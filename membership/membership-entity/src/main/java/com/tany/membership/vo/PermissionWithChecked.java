package com.tany.membership.vo;

import com.tany.membership.entity.SysPermission;

public class PermissionWithChecked extends SysPermission {
    private boolean checked;

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

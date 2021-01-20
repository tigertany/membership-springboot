package com.tany.membership.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public class SysPermissionRelation implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer shareId;

    private Integer permissionId;

    /**
     * 1=role,2=user,3=dept
     */
    private Integer type;


    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SysPermissionRelation{" +
        "shareId=" + shareId +
        ", permissionId=" + permissionId +
        ", type=" + type +
        "}";
    }
}

package com.tany.membership.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tany
 * @since 2021-03-18
 */
public class SysUserRole implements Serializable {

    private static final long serialVersionUID=1L;

    private Long userId;

    private Long roleId;

    private Long creater;

    private Date createDate;

    /**
     * 1=删除,0=未删除
     */
    private Boolean deleted;

    private Long deleter;

    private Date deletedDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getDeleter() {
        return deleter;
    }

    public void setDeleter(Long deleter) {
        this.deleter = deleter;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        ", creater=" + creater +
        ", createDate=" + createDate +
        ", deleted=" + deleted +
        ", deleter=" + deleter +
        ", deletedDate=" + deletedDate +
        "}";
    }
}

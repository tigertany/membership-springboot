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
public class SysDeptUser implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer deptId;

    private Integer userId;


    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SysDeptUser{" +
        "deptId=" + deptId +
        ", userId=" + userId +
        "}";
    }
}

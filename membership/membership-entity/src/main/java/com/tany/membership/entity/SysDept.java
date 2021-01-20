package com.tany.membership.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public class SysDept implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String deptName;

    private String deptCode;

    private String deptDesc;

    private Integer status;

    private Integer parentId;

    private Integer inputer;

    private Date inputDate;

    private Integer deleted;

    private Integer deleter;

    private Date deletedDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getInputer() {
        return inputer;
    }

    public void setInputer(Integer inputer) {
        this.inputer = inputer;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeleter() {
        return deleter;
    }

    public void setDeleter(Integer deleter) {
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
        return "SysDept{" +
        "id=" + id +
        ", deptName=" + deptName +
        ", deptCode=" + deptCode +
        ", deptDesc=" + deptDesc +
        ", status=" + status +
        ", parentId=" + parentId +
        ", inputer=" + inputer +
        ", inputDate=" + inputDate +
        ", deleted=" + deleted +
        ", deleter=" + deleter +
        ", deletedDate=" + deletedDate +
        "}";
    }
}

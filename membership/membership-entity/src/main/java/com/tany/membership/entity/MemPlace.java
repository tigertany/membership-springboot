package com.tany.membership.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tany
 * @since 2021-03-18
 */
public class MemPlace implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String place;

    private String remark;

    private Long creater;

    private Date createDate;

    private Long updater;

    private Date updateDate;

    /**
     * 1=删除,0=未删除
     */
    private Boolean deleted;

    private Long deleter;

    private Date deletedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        return "MemPlace{" +
        "id=" + id +
        ", place=" + place +
        ", remark=" + remark +
        ", creater=" + creater +
        ", createDate=" + createDate +
        ", updater=" + updater +
        ", updateDate=" + updateDate +
        ", deleted=" + deleted +
        ", deleter=" + deleter +
        ", deletedDate=" + deletedDate +
        "}";
    }
}

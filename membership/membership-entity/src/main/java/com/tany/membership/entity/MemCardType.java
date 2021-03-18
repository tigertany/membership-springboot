package com.tany.membership.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author tany
 * @since 2021-03-18
 */
public class MemCardType implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String prefix;

    private String name;

    /**
     * 1=消费现金,2=消费次数,3=时段内任意消费
     */
    private String type;

    private BigDecimal faceMoney;

    private BigDecimal faceTimes;

    private BigDecimal faceMonth;

    private Integer expireMonth;

    private String remark;

    private Long creater;

    private Date createDate;

    private Long updater;

    private Date updateDate;

    /**
     * 1=删除,0=未删除
     */
    private Integer deleted;

    private Long deleter;

    private Date deletedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getFaceMoney() {
        return faceMoney;
    }

    public void setFaceMoney(BigDecimal faceMoney) {
        this.faceMoney = faceMoney;
    }

    public BigDecimal getFaceTimes() {
        return faceTimes;
    }

    public void setFaceTimes(BigDecimal faceTimes) {
        this.faceTimes = faceTimes;
    }

    public BigDecimal getFaceMonth() {
        return faceMonth;
    }

    public void setFaceMonth(BigDecimal faceMonth) {
        this.faceMonth = faceMonth;
    }

    public Integer getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(Integer expireMonth) {
        this.expireMonth = expireMonth;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
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
        return "MemCardType{" +
        "id=" + id +
        ", prefix=" + prefix +
        ", name=" + name +
        ", type=" + type +
        ", faceMoney=" + faceMoney +
        ", faceTimes=" + faceTimes +
        ", faceMonth=" + faceMonth +
        ", expireMonth=" + expireMonth +
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

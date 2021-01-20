package com.tany.membership.entity;

import java.math.BigDecimal;
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
public class MemCardType implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

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
        return "MemCardType{" +
        "id=" + id +
        ", prefix=" + prefix +
        ", name=" + name +
        ", type=" + type +
        ", faceMoney=" + faceMoney +
        ", faceTimes=" + faceTimes +
        ", faceMonth=" + faceMonth +
        ", expireMonth=" + expireMonth +
        ", inputer=" + inputer +
        ", inputDate=" + inputDate +
        ", deleted=" + deleted +
        ", deleter=" + deleter +
        ", deletedDate=" + deletedDate +
        "}";
    }
}

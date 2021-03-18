package com.tany.membership.entity;

import java.math.BigDecimal;
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
public class MemCardInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String cardNo;

    private String innerNo;

    private String tel;

    /**
     * 1=现金消费,2=次数消费,3=时段内消费
     */
    private Integer type;

    private BigDecimal faceMoney;

    private BigDecimal realMoney;

    private BigDecimal faceTimes;

    private BigDecimal realTimes;

    private BigDecimal balance;

    private BigDecimal balanceTimes;

    private Date expire;

    private Date openDate;

    private String cardnoNew;

    private String innernoNew;

    /**
     * 1=正常,2=挂失,3=遗失换新此卡作废
     */
    private Integer status;

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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getInnerNo() {
        return innerNo;
    }

    public void setInnerNo(String innerNo) {
        this.innerNo = innerNo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getFaceMoney() {
        return faceMoney;
    }

    public void setFaceMoney(BigDecimal faceMoney) {
        this.faceMoney = faceMoney;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public BigDecimal getFaceTimes() {
        return faceTimes;
    }

    public void setFaceTimes(BigDecimal faceTimes) {
        this.faceTimes = faceTimes;
    }

    public BigDecimal getRealTimes() {
        return realTimes;
    }

    public void setRealTimes(BigDecimal realTimes) {
        this.realTimes = realTimes;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalanceTimes() {
        return balanceTimes;
    }

    public void setBalanceTimes(BigDecimal balanceTimes) {
        this.balanceTimes = balanceTimes;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getCardnoNew() {
        return cardnoNew;
    }

    public void setCardnoNew(String cardnoNew) {
        this.cardnoNew = cardnoNew;
    }

    public String getInnernoNew() {
        return innernoNew;
    }

    public void setInnernoNew(String innernoNew) {
        this.innernoNew = innernoNew;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "MemCardInfo{" +
        "id=" + id +
        ", cardNo=" + cardNo +
        ", innerNo=" + innerNo +
        ", tel=" + tel +
        ", type=" + type +
        ", faceMoney=" + faceMoney +
        ", realMoney=" + realMoney +
        ", faceTimes=" + faceTimes +
        ", realTimes=" + realTimes +
        ", balance=" + balance +
        ", balanceTimes=" + balanceTimes +
        ", expire=" + expire +
        ", openDate=" + openDate +
        ", cardnoNew=" + cardnoNew +
        ", innernoNew=" + innernoNew +
        ", status=" + status +
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

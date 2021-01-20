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
public class MemCardInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private String uid;

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

    private Integer inputer;

    private Date inputDate;

    /**
     * 换卡人
     */
    private Integer changer;

    private Date changeDate;

    private String cardnoNew;

    private String innernoNew;

    /**
     * 1=正常,2=挂失,3=遗失换新此卡作废
     */
    private Integer status;

    private Integer deleted;

    private Integer deleter;

    private Date deletedDate;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Integer getChanger() {
        return changer;
    }

    public void setChanger(Integer changer) {
        this.changer = changer;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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
        return "MemCardInfo{" +
        "uid=" + uid +
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
        ", inputer=" + inputer +
        ", inputDate=" + inputDate +
        ", changer=" + changer +
        ", changeDate=" + changeDate +
        ", cardnoNew=" + cardnoNew +
        ", innernoNew=" + innernoNew +
        ", status=" + status +
        ", deleted=" + deleted +
        ", deleter=" + deleter +
        ", deletedDate=" + deletedDate +
        "}";
    }
}

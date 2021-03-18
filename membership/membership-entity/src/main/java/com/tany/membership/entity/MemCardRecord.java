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
public class MemCardRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String cardNo;

    private String innerNo;

    private String cardUid;

    private String type;

    private BigDecimal money;

    private BigDecimal balance;

    private BigDecimal balanceTimes;

    private Integer placeId;

    private Long opr;

    private Date oprDate;


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

    public String getCardUid() {
        return cardUid;
    }

    public void setCardUid(String cardUid) {
        this.cardUid = cardUid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Long getOpr() {
        return opr;
    }

    public void setOpr(Long opr) {
        this.opr = opr;
    }

    public Date getOprDate() {
        return oprDate;
    }

    public void setOprDate(Date oprDate) {
        this.oprDate = oprDate;
    }

    @Override
    public String toString() {
        return "MemCardRecord{" +
        "id=" + id +
        ", cardNo=" + cardNo +
        ", innerNo=" + innerNo +
        ", cardUid=" + cardUid +
        ", type=" + type +
        ", money=" + money +
        ", balance=" + balance +
        ", balanceTimes=" + balanceTimes +
        ", placeId=" + placeId +
        ", opr=" + opr +
        ", oprDate=" + oprDate +
        "}";
    }
}

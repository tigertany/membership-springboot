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
 * @since 2021-01-20
 */
public class MemPlace implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String place;

    private Integer inputer;

    private Date inputDate;

    private Integer deleted;

    private Integer deleter;

    private Date deleteDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "MemPlace{" +
        "id=" + id +
        ", place=" + place +
        ", inputer=" + inputer +
        ", inputDate=" + inputDate +
        ", deleted=" + deleted +
        ", deleter=" + deleter +
        ", deleteDate=" + deleteDate +
        "}";
    }
}

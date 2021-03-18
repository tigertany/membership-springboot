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
public class MemPlaceCard implements Serializable {

    private static final long serialVersionUID=1L;

    private Long placeId;

    private Long cardId;

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


    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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
        return "MemPlaceCard{" +
        "placeId=" + placeId +
        ", cardId=" + cardId +
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

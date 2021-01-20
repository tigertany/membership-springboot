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
public class MemPlaceCard implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer placeId;

    private Integer cardUid;


    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getCardUid() {
        return cardUid;
    }

    public void setCardUid(Integer cardUid) {
        this.cardUid = cardUid;
    }

    @Override
    public String toString() {
        return "MemPlaceCard{" +
        "placeId=" + placeId +
        ", cardUid=" + cardUid +
        "}";
    }
}

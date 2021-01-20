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
public class MemPlaceUser implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer placeId;

    private Integer userId;


    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MemPlaceUser{" +
        "placeId=" + placeId +
        ", userId=" + userId +
        "}";
    }
}

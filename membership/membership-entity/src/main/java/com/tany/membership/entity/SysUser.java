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
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String account;

    private String username;

    private String password;

    /**
     * 1=锁定,0=未锁定
     */
    private Integer locked;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
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
        return "SysUser{" +
        "id=" + id +
        ", account=" + account +
        ", username=" + username +
        ", password=" + password +
        ", locked=" + locked +
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

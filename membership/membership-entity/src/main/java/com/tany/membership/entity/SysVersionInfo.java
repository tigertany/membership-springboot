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
public class SysVersionInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String fileName;

    private byte[] fileStream;

    /**
     * 相对根目录
     */
    private String path;

    private BigDecimal versionNo;

    private String remark;

    /**
     * 是否强制更新到这一版本,即便不是最新版
     */
    private Integer forced;

    /**
     * 哪家客户
     */
    private String customer;

    private Date publishDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileStream() {
        return fileStream;
    }

    public void setFileStream(byte[] fileStream) {
        this.fileStream = fileStream;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(BigDecimal versionNo) {
        this.versionNo = versionNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getForced() {
        return forced;
    }

    public void setForced(Integer forced) {
        this.forced = forced;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "SysVersionInfo{" +
        "id=" + id +
        ", fileName=" + fileName +
        ", fileStream=" + fileStream +
        ", path=" + path +
        ", versionNo=" + versionNo +
        ", remark=" + remark +
        ", forced=" + forced +
        ", customer=" + customer +
        ", publishDate=" + publishDate +
        "}";
    }
}

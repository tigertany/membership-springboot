package com.tany.membership.common;

import org.apache.commons.lang3.StringUtils;

public class MyPage {
    private Long pageIndex;
    private Long pageSize;
    private String sortColumn;
    private String sortMethod;

    public MyPage(Long pageIndex, Long pageSize, String sortColumn, String sortMethod) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sortColumn = sortColumn;
        this.sortMethod = sortMethod;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
}

package com.scs.soft.ncp.api.domain.dto;

import lombok.Data;

/**
 * @author Tao
 */
@Data

public class PageDto {
    private Object field;
    private int currentPage;
    private int pageSize;

    @Override
    public String toString() {
        return "PageDto{" +
                "field=" + field +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public PageDto() {
    }

    public PageDto(Object field, int currentPage, int pageSize) {
        this.field = field;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Object getField() {
        return field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

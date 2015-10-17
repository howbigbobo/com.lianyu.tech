package com.lianyu.tech.backoffice.web.request;

public class PageRequest {
    protected static final int DEFAULT_PAGE_SIZE = 10;
    private String orderBy;
    private int page;
    private int pageSize;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
}

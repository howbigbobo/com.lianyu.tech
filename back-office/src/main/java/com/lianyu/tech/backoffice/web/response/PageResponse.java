package com.lianyu.tech.backoffice.web.response;

public class PageResponse {
    private long totalCount;
    private int totalPage;
    private int pageNo;
    private int pageSize;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (totalPage > 0) return totalPage;
        if (pageSize == 0) return 0;
        return (int) Math.ceil(totalCount / pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}

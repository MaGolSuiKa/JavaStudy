package com.geekaca.newsproject.utils;

/**
 * 接收前台发过来的
 * 分页参数
 */
public class PageBean {

    private Integer pageNo;

    private Integer pageSize;

    private Integer newsId;

    private Integer commentStatus;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

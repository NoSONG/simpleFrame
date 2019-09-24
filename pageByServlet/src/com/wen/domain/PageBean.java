package com.wen.domain;

import java.util.List;

public class PageBean<T> {
    private int totalCount;//总条数
    private int pageCount; //总页数
    private List<T> list; // 每页数据
    private int currentPage; //当前页数
    private int rows;//每页数据条数

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", pageCount=" + pageCount +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}

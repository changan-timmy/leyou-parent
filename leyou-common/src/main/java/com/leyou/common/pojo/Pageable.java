package com.leyou.common.pojo;


public class Pageable {
    private Integer page;
    private Integer rows;
    private String sortBy;
    private Boolean desc;

    public Pageable() {
    }

    public Pageable(Integer rows, Integer page) {
        this.rows = rows;
        this.page = page;
    }

    public Pageable(Integer page, Integer rows, String sortBy, Boolean desc) {
        this.rows = rows;
        this.page = page;
        this.sortBy = sortBy;
        this.desc = desc;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

}


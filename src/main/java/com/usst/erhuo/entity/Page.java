package com.usst.erhuo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private Integer totalCount;
    private Integer currentPage;
    private Integer pageSize;
    //当前页的数据
    private List<T> data;

    public Page(Integer totalCount, List<T> data) {
        this.totalCount = totalCount;
        this.data = data;
    }

    public Page() {
    }
}

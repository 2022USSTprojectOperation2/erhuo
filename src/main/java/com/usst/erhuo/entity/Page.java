package com.usst.erhuo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private Integer totalCount;
    private List<T> rows;

    public Page(Integer totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public Page() {
    }
}

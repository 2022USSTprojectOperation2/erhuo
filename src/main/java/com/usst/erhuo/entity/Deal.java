package com.usst.erhuo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deal {
    private int id;
    private int userId;
    private int goodsId;
    private int num;
    private int price;
    private int flag; //约定后更新此条
}

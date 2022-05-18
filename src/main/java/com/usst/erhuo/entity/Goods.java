package com.usst.erhuo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goods {
    private int id;
    private String goodsName;
    private int sellId;
    private double price;
    private String imgPath;
    private String introduction;
    private int flag;
}

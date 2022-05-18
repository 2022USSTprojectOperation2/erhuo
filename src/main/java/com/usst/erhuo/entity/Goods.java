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
    private String imgPath;  //封面图
    private String introduction;
    private int flag;  //约定各状态后更新此条
    private int kindId;
    private int likelevel;
}

package com.usst.erhuo.vo;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

@Getter
@Setter
public class AdminDeal {
    private int id;
    private float price;
    private String goodsName;
    private String userName;
    private int userId;
    private int goodsId;
    private String KindName;
    private int flag;
}

package com.usst.erhuo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Message {
    private int id;
    private int goodsId;
    private int userId;
    private String content;
    private Date date;

}

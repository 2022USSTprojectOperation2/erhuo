package com.usst.erhuo.vo;

import com.usst.erhuo.entity.Deal;
import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.User;
import lombok.Data;

@Data
public class DealHistory {
    private Deal deal;
    private Goods goods;
    private User user;
    private String state;
}

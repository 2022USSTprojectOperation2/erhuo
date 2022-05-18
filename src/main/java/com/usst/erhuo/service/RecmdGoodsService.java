package com.usst.erhuo.service;

import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.User;

import java.util.List;

public interface RecmdGoodsService {
    List<Goods> getRecmdGoods(Integer uid);

}

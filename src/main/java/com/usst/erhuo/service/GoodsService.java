package com.usst.erhuo.service;

import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Page;

public interface GoodsService {
    Page<Goods> getAll(Integer currentPage,Integer pageSize);
    Page<Goods> getByUser(Integer currentPage,Integer pageSize,Integer userId);
    Page<Goods> getByKind(Integer currentPage,Integer pageSize,Integer kindId);
    Boolean add(Goods goods);
    Boolean update(Goods goods);
    Boolean delete(Goods goods);
    Boolean buy(Goods goods,Integer userId);
}

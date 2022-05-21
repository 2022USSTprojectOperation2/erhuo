package com.usst.erhuo.service.impl;

import com.usst.erhuo.dao.GoodsDao;
import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Page<Goods> getAll(Integer currentPage, Integer pageSize) {
        Page<Goods> page=new Page<>();
        page.setTotalCount(goodsDao.getSum());
        page.setData(goodsDao.selectAllByPage(currentPage,pageSize));
        return page;
    }

    @Override
    public Page<Goods> getByUser(Integer currentPage, Integer pageSize, Integer userId) {
        Page<Goods> page=new Page<>();
        page.setTotalCount(goodsDao.getSumByUser(userId));
        page.setData(goodsDao.selectByUser(userId,currentPage,pageSize));
        return page;
    }

    @Override
    public Page<Goods> getByKind(Integer currentPage, Integer pageSize, Integer kindId) {
        Page<Goods> page=new Page<>();
        page.setTotalCount(goodsDao.getSumByKind(kindId));
        page.setData(goodsDao.selectByKind(kindId,currentPage,pageSize));
        return page;
    }

    @Override
    public Boolean add(Goods goods) {
        return goodsDao.insert(goods.getGoodsName(),goods.getSellId(),goods.getPrice(),goods.getImgPath(),goods.getIntroduction(),goods.getKindId())>0;
    }

    @Override
    public Boolean update(Goods goods) {
        return goodsDao.update(goods.getId(),goods.getGoodsName(),goods.getPrice(),goods.getImgPath(),goods.getIntroduction(),goods.getKindId())>0;
    }

    @Override
    public Boolean delete(Goods goods) {
        return null;
    }

    @Override
    public Boolean buy(Goods goods, Integer userId) {
        return null;
    }
}

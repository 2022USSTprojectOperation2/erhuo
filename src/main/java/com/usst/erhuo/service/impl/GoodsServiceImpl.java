package com.usst.erhuo.service.impl;

import com.usst.erhuo.dao.GoodsDao;
import com.usst.erhuo.dao.ImgDao;
import com.usst.erhuo.dao.KindDao;
import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Kind;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private KindDao kindDao;

    @Autowired
    private ImgDao imgDao;

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
    public Integer add(Goods goods) {
        goodsDao.insert(goods.getGoodsName(),goods.getSellId(),goods.getPrice(),goods.getImgPath(),goods.getIntroduction(),goods.getKindId());
        return goodsDao.selectIdByImgPath(goods.getImgPath());
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

    @Override
    public List<Kind> getKindList() {
        return kindDao.selectAll();
    }

    @Override
    public Boolean addDetails(List<String> imgPathList, Integer goodsId) {
        for(String imgPath:imgPathList){
            imgDao.insertImage(goodsId,imgPath);
        }
        return true;
    }

    @Override
    public Goods getById(Integer id) {
        return goodsDao.selectById(id);
    }
}

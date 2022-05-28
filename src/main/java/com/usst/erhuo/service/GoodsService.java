package com.usst.erhuo.service;


import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Kind;
import com.usst.erhuo.entity.Page;

import java.util.List;

public interface GoodsService {
    Page<Goods> getAll(Integer currentPage,Integer pageSize);
    Page<Goods> getByUser(Integer currentPage,Integer pageSize,Integer userId);
    Page<Goods> getByKind(Integer currentPage,Integer pageSize,Integer kindId);
    Page<Goods> getByKeyWord(Integer currentPage,Integer pageSize,String keyWord);
    Page<Goods> getByKindAndKeyWord(Integer currentPage,Integer pageSize,Integer kindId,String keyWord);
    Page<Goods> getByLikeLevel(Integer currentPage,Integer pageSize);
    Page<Goods> getByKindAndLikeLevel(Integer currentPage,Integer pageSize,Integer kindId);
    Page<Goods> getByKeyWordAndLikeLevel(Integer currentPage,Integer pageSize,String keyWord);
    Page<Goods> getByKindAndKeyWordAndLikeLevel(Integer currentPage,Integer pageSize,Integer kindId,String keyWord);
    Goods getById(Integer id);
    Integer add(Goods goods);
    Boolean update(Goods goods);
    Boolean delete(Goods goods);
    Boolean addDetails(List<String> imgPathList,Integer goodsId);
    Boolean updateDetails(List<String> imgPathList,Integer goodsId);
    Boolean addLikeLevel(Integer id);
    List<String> getDetails(Integer id);
    List<Kind> getKindList();
}

package com.usst.erhuo.service;


import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.vo.AdminDeal;
import com.usst.erhuo.vo.AdminGoods;
import com.usst.erhuo.vo.AdminReport;

public interface AdminService {

    Integer adminLogin(String name,String password);

    Page<AdminDeal> getAllDeal(Integer currentPage, Integer pageSize);
    Page<AdminDeal> getKindDeal(Integer currentPage,Integer pageSize,Integer kindId);
    Page<AdminDeal> getKeyDeal(Integer currentPage,Integer pageSize,String keyWord);
    Page<AdminDeal> getKindKeyDeal(Integer currentPage,Integer pageSize,Integer kindId,String keyWord);

    Page<AdminGoods> getAllGoods(Integer currentPage, Integer pageSize);
    Page<AdminGoods> getKindGoods(Integer currentPage,Integer pageSize,Integer kindId);
    Page<AdminGoods> getKeyGoods(Integer currentPage,Integer pageSize,String keyWord);
    Page<AdminGoods> getKindKeyGoods(Integer currentPage,Integer pageSize,Integer kindId,String keyWord);


    Page<AdminReport> getReport(Integer currentPage, Integer pageSize);


    void downReport(Integer id);

    void cancelReport(Integer id);
}

package com.usst.erhuo.service;

import com.usst.erhuo.entity.Deal;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.vo.DealHistory;

public interface DealService {
    Boolean purchase(Integer purchaser,Integer goodsId);
    Boolean checkDeal(Integer id);
    Boolean argueDeal(Integer dealId,Integer userId,String reason);
    Boolean purchaseHideDeal(Integer id);
    Boolean sellHideDeal(Integer id);
    Page<DealHistory> getAllPurchase(Integer purchase, Integer currentPage, Integer pageSize);
    Page<DealHistory> getDealingPurchase(Integer purchase,Integer currentPage,Integer pageSize);
    Page<DealHistory> getDonePurchase(Integer purchase,Integer currentPage,Integer pageSize);
    Page<DealHistory> getFailedPurchase(Integer purchase,Integer currentPage,Integer pageSize);
    Page<DealHistory> getAllSell(Integer seller,Integer currentPage,Integer pageSize);
    Page<DealHistory> getDealingSell(Integer seller,Integer currentPage,Integer pageSize);
    Page<DealHistory> getDoneSell(Integer seller,Integer currentPage,Integer pageSize);
    Page<DealHistory> getFailedSell(Integer seller,Integer currentPage,Integer pageSize);
}

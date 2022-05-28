package com.usst.erhuo.service.impl;

import com.usst.erhuo.dao.DealDao;
import com.usst.erhuo.dao.GoodsDao;
import com.usst.erhuo.dao.ReportDao;
import com.usst.erhuo.dao.UserDao;
import com.usst.erhuo.entity.Deal;
import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.service.DealService;
import com.usst.erhuo.vo.DealHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealDao dealDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ReportDao reportDao;

    private String getState(Integer flag) {
        switch (flag) {
            case 0:
            case 6:
            case 7:
                return "交易失败";
            case 1:
                return "交易中";
            case 2:
            case 3:
            case 4:
                return "交易完成";
            default:
                return "";
        }
    }

    private List<DealHistory> getPurchaseHistory(List<Deal> dealList){
        List<DealHistory> dealHistoryList = new ArrayList<>();
        for (Deal deal : dealList) {
            DealHistory dealHistory = new DealHistory();
            dealHistory.setDeal(deal);
            Integer goodsId = deal.getGoodsId();
            Goods goods = goodsDao.selectById(goodsId);
            dealHistory.setGoods(goods);
            dealHistory.setUser(userDao.getUserInfo(goods.getSellId()));
            dealHistory.setState(getState(deal.getFlag()));
            dealHistoryList.add(dealHistory);
        }
        return dealHistoryList;
    }

    private List<DealHistory> getSellHistory(List<Deal> dealList){
        List<DealHistory> dealHistoryList = new ArrayList<>();
        for (Deal deal : dealList) {
            DealHistory dealHistory = new DealHistory();
            dealHistory.setDeal(deal);
            Integer goodsId = deal.getGoodsId();
            Goods goods = goodsDao.selectById(goodsId);
            dealHistory.setGoods(goods);
            dealHistory.setUser(userDao.getUserInfo(deal.getUserId()));
            dealHistory.setState(getState(deal.getFlag()));
            dealHistoryList.add(dealHistory);
        }
        return dealHistoryList;
    }

    @Override
    public Boolean purchase(Integer purchaser, Integer goodsId) {
        goodsDao.updateFlag(goodsId, 1);
        return dealDao.insert(purchaser, goodsId) > 0;
    }

    @Override
    public Page<DealHistory> getAllPurchase(Integer purchase, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfAllByPurchaser(purchase));
        page.setData(getPurchaseHistory(dealDao.selectAllByPurchaser(purchase, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getDonePurchase(Integer purchase, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfDoneByPurchaser(purchase));
        page.setData(getPurchaseHistory(dealDao.selectDoneByPurchaser(purchase, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getFailedPurchase(Integer purchase, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfFailedByPurchaser(purchase));
        page.setData(getPurchaseHistory(dealDao.selectFailedByPurchaser(purchase, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getAllSell(Integer seller, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfAllBySeller(seller));
        page.setData(getSellHistory(dealDao.selectAllBySeller(seller, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getDoneSell(Integer seller, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfDoneBySeller(seller));
        page.setData(getSellHistory(dealDao.selectDoneBySeller(seller, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getFailedSell(Integer seller, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfFailedBySeller(seller));
        page.setData(getSellHistory(dealDao.selectFailedBySeller(seller, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getDealingPurchase(Integer purchase, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfDealingByPurchaser(purchase));
        page.setData(getPurchaseHistory(dealDao.selectDealingByPurchaser(purchase, currentPage, pageSize)));
        return page;
    }

    @Override
    public Page<DealHistory> getDealingSell(Integer seller, Integer currentPage, Integer pageSize) {
        Page<DealHistory> page = new Page<>();
        page.setTotalCount(dealDao.selectSumOfDealingBySeller(seller));
        page.setData(getSellHistory(dealDao.selectDealingBySeller(seller, currentPage, pageSize)));
        return page;
    }

    @Override
    public Boolean checkDeal(Integer id) {
        Deal deal=dealDao.selectById(id);
        goodsDao.updateFlag(deal.getGoodsId(),2);
        return dealDao.updateFlag(id,2)>0;
    }

    @Override
    public Boolean argueDeal(Integer dealId,Integer userId,String reason) {
        Deal deal=dealDao.selectById(dealId);
        Integer goodsId=deal.getGoodsId();
        goodsDao.updateFlag(goodsId,3);
        reportDao.insertReport(goodsId,userId,reason);
        return dealDao.updateFlag(dealId,0)>0;
    }

    @Override
    public Boolean purchaseHideDeal(Integer id) {
        Deal deal=dealDao.selectById(id);
        Integer flag=deal.getFlag();
        if(flag==2){
            flag=4;
        }
        else if(flag==0){
            flag=7;
        }
        else if(flag==6||flag==3){
            flag=5;
        }
        return dealDao.updateFlag(id,flag)>0;
    }

    @Override
    public Boolean sellHideDeal(Integer id) {
        Deal deal=dealDao.selectById(id);
        Integer flag=deal.getFlag();
        if(flag==2){
            flag=3;
        }
        else if(flag==0){
            flag=6;
        }
        else if(flag==7||flag==4){
            flag=5;
        }
        return dealDao.updateFlag(id,flag)>0;
    }
}

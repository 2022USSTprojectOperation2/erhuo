package com.usst.erhuo.service.impl;


import com.usst.erhuo.dao.AdminDao;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.service.AdminService;
import com.usst.erhuo.vo.AdminDeal;
import com.usst.erhuo.vo.AdminGoods;
import com.usst.erhuo.vo.AdminReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Integer adminLogin(String name,String password) {
        return adminDao.adminLogin(name,password);
    }


    @Override
    public Page<AdminDeal> getAllDeal(Integer currentPage, Integer pageSize) {
        Page<AdminDeal> page=new Page<>();
        page.setTotalCount(adminDao.getSum());
        page.setData(adminDao.adminDeal(currentPage,pageSize));
        return page;
    }



    @Override
    public Page<AdminDeal> getKindDeal(Integer currentPage, Integer pageSize, Integer kindId) {
        Page<AdminDeal> page=new Page<>();
        page.setTotalCount(adminDao.getKindDealSum(kindId));
        page.setData(adminDao.getKindDeal(currentPage,pageSize,kindId));
        return page;
    }

    @Override
    public Page<AdminDeal> getKeyDeal(Integer currentPage, Integer pageSize, String keyWord) {
        Page<AdminDeal> page=new Page<>();
        page.setTotalCount(adminDao.getKeyDealSum(keyWord));
        page.setData(adminDao.getKeyDeal(currentPage,pageSize,keyWord));
        return page;
    }

    @Override
    public Page<AdminDeal> getKindKeyDeal(Integer currentPage, Integer pageSize, Integer kindId, String keyWord) {
        Page<AdminDeal> page=new Page<>();
        page.setTotalCount(adminDao.getKindKeyDealSum(kindId,keyWord));
        page.setData(adminDao.getKindKeyDeal(currentPage,pageSize,kindId,keyWord));
        return page;
    }

    @Override
    public Page<AdminGoods> getAllGoods(Integer currentPage, Integer pageSize) {
        Page<AdminGoods> page=new Page<>();
        page.setTotalCount(adminDao.getGoodsSum());
        page.setData(adminDao.adminGoods(currentPage,pageSize));
        return page;
    }



    @Override
    public Page<AdminGoods> getKindGoods(Integer currentPage, Integer pageSize, Integer kindId) {
        Page<AdminGoods> page=new Page<>();
        page.setTotalCount(adminDao.getKindGoodsSum(kindId));
        page.setData(adminDao.getKindGoods(currentPage,pageSize,kindId));
        return page;
    }

    @Override
    public Page<AdminGoods> getKeyGoods(Integer currentPage, Integer pageSize, String keyWord) {
        Page<AdminGoods> page=new Page<>();
        page.setTotalCount(adminDao.getKeyGoodsSum(keyWord));
        page.setData(adminDao.getKeyGoods(currentPage,pageSize,keyWord));
        return page;
    }

    @Override
    public Page<AdminGoods> getKindKeyGoods(Integer currentPage, Integer pageSize, Integer kindId, String keyWord) {
        Page<AdminGoods> page=new Page<>();
        page.setTotalCount(adminDao.getKindKeyGoodsSum(kindId,keyWord));
        page.setData(adminDao.getKindKeyGoods(currentPage,pageSize,kindId,keyWord));
        return page;
    }

    @Override
    public Page<AdminReport> getReport(Integer currentPage, Integer pageSize) {
        Page<AdminReport> page=new Page<>();
        page.setTotalCount(adminDao.getReportSum());
        page.setData(adminDao.adminReport(currentPage,pageSize));
        return page;
    }

    @Override
    public void downReport(Integer id) {
        adminDao.downReport(id);
        adminDao.deleReport(id);

    }

    @Override
    public void cancelReport(Integer id) {
        adminDao.cancelReport(id);
        adminDao.deleReport(id);
    }
}

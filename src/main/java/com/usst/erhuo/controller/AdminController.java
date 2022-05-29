package com.usst.erhuo.controller;


import com.usst.erhuo.entity.Admin;

import com.usst.erhuo.entity.Page;
import com.usst.erhuo.service.AdminService;
import com.usst.erhuo.vo.AdminDeal;
import com.usst.erhuo.vo.AdminGoods;
import com.usst.erhuo.vo.AdminReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public Integer userLogin(@RequestBody Admin admin, HttpSession session){
        Integer id = adminService.adminLogin(admin.getName(),admin.getPassword());
        if(id!=null) session.setAttribute("adminId",id);
        return id;
    }


    @GetMapping("/deal/{pageSize}/{currentPage}")
    public Page<AdminDeal> getDealList(@PathVariable Integer pageSize, @PathVariable Integer currentPage){
        return adminService.getAllDeal(currentPage,pageSize);
    }

    @GetMapping("/kindDeal/{kindId}/{pageSize}/{currentPage}")
    public Page<AdminDeal> getKindDealList(@PathVariable Integer kindId, @PathVariable Integer pageSize, @PathVariable Integer currentPage){
        return adminService.getKindDeal(currentPage,pageSize,kindId);
    }


    @GetMapping("/keyDeal/{keyWord}/{pageSize}/{currentPage}")
    public Page<AdminDeal> getKeyDeal(@PathVariable String keyWord, @PathVariable Integer pageSize, @PathVariable Integer currentPage){
        return adminService.getKeyDeal(currentPage,pageSize,keyWord);
    }

    //根据类别和关键字获取商品
    @GetMapping("/kindKeyDeal/{kindId}/{keyWord}/{pageSize}/{currentPage}")
    public Page<AdminDeal> getKindKeyDeal(@PathVariable Integer kindId,@PathVariable String keyWord,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return adminService.getKindKeyDeal(currentPage,pageSize,kindId,keyWord);
    }







    @GetMapping("/goods/{pageSize}/{currentPage}")
    public Page<AdminGoods> getGoodsList(@PathVariable Integer pageSize, @PathVariable Integer currentPage){
        return adminService.getAllGoods(currentPage,pageSize);
    }

    @GetMapping("/kindGoods/{kindId}/{pageSize}/{currentPage}")
    public Page<AdminGoods> getKindGoodsList(@PathVariable Integer kindId, @PathVariable Integer pageSize, @PathVariable Integer currentPage){
        return adminService.getKindGoods(currentPage,pageSize,kindId);
    }


    @GetMapping("/keyGoods/{keyWord}/{pageSize}/{currentPage}")
    public Page<AdminGoods> getKeyGoods(@PathVariable String keyWord, @PathVariable Integer pageSize, @PathVariable Integer currentPage){
        return adminService.getKeyGoods(currentPage,pageSize,keyWord);
    }

    //根据类别和关键字获取商品
    @GetMapping("/kindKeyGoods/{kindId}/{keyWord}/{pageSize}/{currentPage}")
    public Page<AdminGoods> getKindKeyGoods(@PathVariable Integer kindId,@PathVariable String keyWord,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return adminService.getKindKeyGoods(currentPage,pageSize,kindId,keyWord);
    }



    @GetMapping("report/{pageSize}/{currentPage}")
    public Page<AdminReport> getReport(@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return adminService.getReport(currentPage,pageSize);
    }


    @GetMapping("cancelReport/{id}")
    public void cancelReport(@PathVariable Integer id){
        adminService.cancelReport(id);
    }


    @GetMapping("downReport/{id}")
    public void downReport(@PathVariable Integer id){
        adminService.downReport(id);
    }















}

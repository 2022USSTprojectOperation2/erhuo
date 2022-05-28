package com.usst.erhuo.controller;

import com.usst.erhuo.entity.Deal;
import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Page;
import com.usst.erhuo.service.DealService;
import com.usst.erhuo.vo.DealHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping
    public Boolean purchase(@RequestBody Goods goods, HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        //不能买自己的商品
        if(goods.getSellId()==userId){
            return false;
        }
        return dealService.purchase(userId, goods.getId());
    }

    @GetMapping("/myPurchase/all/{pageSize}/{currentPage}")
    public Page<DealHistory> getAllPurchase(@PathVariable Integer pageSize, @PathVariable Integer currentPage, HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getAllPurchase(userId,currentPage,pageSize);
    }

    @GetMapping("/myPurchase/dealing/{pageSize}/{currentPage}")
    public Page<DealHistory> getDealingPurchase(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getDealingPurchase(userId,currentPage,pageSize);
    }

    @GetMapping("/myPurchase/done/{pageSize}/{currentPage}")
    public Page<DealHistory> getDonePurchase(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getDonePurchase(userId,currentPage,pageSize);
    }

    @GetMapping("/myPurchase/failed/{pageSize}/{currentPage}")
    public Page<DealHistory> getFailedPurchase(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getFailedPurchase(userId,currentPage,pageSize);
    }

    @GetMapping("/mySell/all/{pageSize}/{currentPage}")
    public Page<DealHistory> getAllSell(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getAllSell(userId,currentPage,pageSize);
    }

    @GetMapping("/mySell/dealing/{pageSize}/{currentPage}")
    public Page<DealHistory> getDealingSell(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getDealingSell(userId,currentPage,pageSize);
    }

    @GetMapping("/mySell/done/{pageSize}/{currentPage}")
    public Page<DealHistory> getDoneSell(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getDoneSell(userId,currentPage,pageSize);
    }

    @GetMapping("/mySell/failed/{pageSize}/{currentPage}")
    public Page<DealHistory> getFailedSell(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.getFailedSell(userId,currentPage,pageSize);
    }

    @PutMapping("/checkDeal/{id}")
    public Boolean checkDeal(@PathVariable Integer id){
        return dealService.checkDeal(id);
    }

    @PostMapping("/argueDeal/{id}")
    public Boolean argueDeal(@PathVariable Integer id,@RequestBody String reason,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return dealService.argueDeal(id,userId,reason.substring(0,reason.length()-1));
    }

    @PutMapping("/purchaseHideDeal/{id}")
    public Boolean purchaseHideDeal(@PathVariable Integer id){
        return dealService.purchaseHideDeal(id);
    }

    @PutMapping("/sellHideDeal/{id}")
    public Boolean sellHideDeal(@PathVariable Integer id){
        return dealService.sellHideDeal(id);
    }
}

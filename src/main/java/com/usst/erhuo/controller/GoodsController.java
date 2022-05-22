package com.usst.erhuo.controller;

import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Kind;
import com.usst.erhuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //获取类别列表
    @GetMapping("/kindList")
    public List<Kind> getKindList(){
        return goodsService.getKindList();
    }

    //添加商品,返回商品的id
    @PostMapping()
    public Integer addGoods(@RequestBody Goods goods, HttpSession session){
        Integer sellId=(Integer) session.getAttribute("userId");
        goods.setSellId(sellId);
        return goodsService.add(goods);
    }

    @PostMapping("/addDetails/{goodsId}")
    public Boolean addDetails(@RequestBody List<String> imgPathList,@PathVariable Integer goodsId){
        return goodsService.addDetails(imgPathList,goodsId);
    }
}

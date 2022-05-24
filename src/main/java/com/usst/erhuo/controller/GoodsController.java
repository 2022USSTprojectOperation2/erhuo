package com.usst.erhuo.controller;

import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Kind;
import com.usst.erhuo.entity.Page;
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

    //为商品添加详情图，需要传商品id和图片路径的列表
    @PostMapping("/details/{goodsId}")
    public Boolean addDetails(@RequestBody List<String> imgPathList,@PathVariable Integer goodsId){
        return goodsService.addDetails(imgPathList,goodsId);
    }

    //获取商品列表
    @GetMapping("/all/{pageSize}/{currentPage}")
    public Page<Goods> getGoodsList(@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getAll(currentPage,pageSize);
    }

    //根据id获取商品
    @GetMapping("/{id}")
    public Goods getGoods(@PathVariable Integer id){
        return goodsService.getById(id);
    }

    //根据id获取商品详情图的路径列表
    @GetMapping("/details/{id}")
    public List<String> getDetails(@PathVariable Integer id){
        return goodsService.getDetails(id);
    }

    //修改商品信息
    @PutMapping()
    public Boolean updateGoods(@RequestBody Goods goods,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        if(goods.getSellId()!=userId){
            return false;
        }
        return goodsService.update(goods);
    }

    //修改商品详情图
    @PutMapping("/details/{goodsId}")
    public Boolean updateDetails(@RequestBody List<String> imgPathList,@PathVariable Integer goodsId){
        return goodsService.updateDetails(imgPathList,goodsId);
    }
}

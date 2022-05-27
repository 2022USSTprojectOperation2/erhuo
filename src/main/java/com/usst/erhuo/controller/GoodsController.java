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

    //获取当前登录的用户的所有商品
    @GetMapping("/myGoods/{pageSize}/{currentPage}")
    public Page<Goods> getMyGoods(@PathVariable Integer pageSize,@PathVariable Integer currentPage,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        return goodsService.getByUser(currentPage,pageSize,userId);
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

    @DeleteMapping("/{id}")
    public Boolean deleteGoods(@PathVariable Integer id){
        Goods goods=new Goods();
        goods.setId(id);
        return goodsService.delete(goods);
    }

    //根据类别获取商品
    @GetMapping("/kind/{id}/{pageSize}/{currentPage}")
    public Page<Goods> getByKind(@PathVariable Integer id,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByKind(currentPage,pageSize,id);
    }

    //根据关键字获取商品
    @GetMapping("/keyWord/{keyWord}/{pageSize}/{currentPage}")
    public Page<Goods> getByKeyWord(@PathVariable String keyWord,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByKeyWord(currentPage,pageSize,keyWord);
    }

    //根据类别和关键字获取商品
    @GetMapping("/kindAndKeyWord/{id}/{keyWord}/{pageSize}/{currentPage}")
    public Page<Goods> getByKindAndKeyWord(@PathVariable Integer id,@PathVariable String keyWord,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByKindAndKeyWord(currentPage,pageSize,id,keyWord);
    }

    //以下添加按热度排序

    //根据类别获取商品
    @GetMapping("/kindAndLikeLevel/{id}/{pageSize}/{currentPage}")
    public Page<Goods> getByKindAndLikeLevel(@PathVariable Integer id,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByKindAndLikeLevel(currentPage,pageSize,id);
    }

    //根据关键字获取商品
    @GetMapping("/keyWordAndLikeLevel/{keyWord}/{pageSize}/{currentPage}")
    public Page<Goods> getByKeyWordAndLevel(@PathVariable String keyWord,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByKeyWordAndLikeLevel(currentPage,pageSize,keyWord);
    }

    //根据类别和关键字获取商品
    @GetMapping("/kindAndKeyWordAndLikeLevel/{id}/{keyWord}/{pageSize}/{currentPage}")
    public Page<Goods> getByKindAndKeyWordAndLikeLevel(@PathVariable Integer id,@PathVariable String keyWord,@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByKindAndKeyWordAndLikeLevel(currentPage,pageSize,id,keyWord);
    }

    //获取商品列表
    @GetMapping("/likeLevel/{pageSize}/{currentPage}")
    public Page<Goods> getGoodsListByLikeLevel(@PathVariable Integer pageSize,@PathVariable Integer currentPage){
        return goodsService.getByLikeLevel(currentPage,pageSize);
    }

    //给商品增加热度值
    @PutMapping("/likeLevel/{id}")
    public Boolean addLikeLevel(@PathVariable Integer id){
        return goodsService.addLikeLevel(id);
    }
}

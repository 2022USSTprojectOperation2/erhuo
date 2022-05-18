package com.usst.erhuo;

import com.usst.erhuo.dao.GoodsDao;
import com.usst.erhuo.entity.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsDaoTests {
    @Autowired
    GoodsDao goodsDao;

    @Test
    void testInsertGoods(){
        Integer result=goodsDao.insert("书",1,10.5,"12312","书",1);
        System.out.println(result);
    }

    @Test
    void testDeleteGoods(){
        Integer result=goodsDao.delete(1);
        System.out.println(result);
    }

    @Test
    void testUpdate(){
        System.out.println(goodsDao.update(2,"手机",5000.0,"img","二手手机",1));
    }

    @Test
    void testSelect(){
        System.out.println("-------------------");
        Goods goods= goodsDao.selectById(2);
        System.out.println(goods.getGoodsName());
    }

    @Test
    void testSelectByPage(){
        goodsDao.selectByUserAndPage(1,2,2);
    }

    @Test
    void testSum(){
        System.out.println(goodsDao.getSum());
    }
}

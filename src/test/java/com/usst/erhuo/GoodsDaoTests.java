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
        System.out.println(goodsDao.selectAllByPage(1,5));
    }


    @Test
    void testSum(){
        System.out.println(goodsDao.getSum());
    }
}

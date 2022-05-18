package com.usst.erhuo.dao;

import com.usst.erhuo.entity.Goods;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodsDao {
    //添加新商品，参数先这些看着改吧，返回1成功，返回0失败
    @Insert("insert into tb_goods(goodsName,sellId,price,imgPath,introduction,kindId) values (#{goodsName},#{sellId},#{price},#{imgPath},#{introduction},#{kindId})")
    Integer insert(String goodsName,Integer sellId,Double price,String imgPath,String introduction,Integer kindId);

    //删除商品，返回1成功，返回0失败
    @Delete("delete from tb_goods where id=#{id}")
    Integer delete(Integer id);

    //修改商品，参数先这些看着改吧，返回1成功，返回0失败
    @Update("update tb_goods set goodsName=#{goodsName},price=#{price},imgPath=#{imgPath},introduction=#{introduction},kindId=#{kindId} where id=#{id}")
    Integer update(Integer id,String goodsName,Double price,String imgPath,String introduction,Integer kindId);

    //通过商品id查商品
    @Select("select * from tb_goods where id=#{id}")
    Goods selectById(Integer id);


}

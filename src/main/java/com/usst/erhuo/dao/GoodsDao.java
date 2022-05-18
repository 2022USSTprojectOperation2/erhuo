package com.usst.erhuo.dao;

import com.usst.erhuo.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

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


    //通过商品id查单个商品
    @Select("select * from tb_goods where id=#{id}")
    Goods selectById(Integer id);


    //分页查询用户发布的商品
    @Select("select * from tb_goods where sellId=#{sellId} limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByUserAndPage(Integer sellId,Integer currentPage,Integer pageSize);


    //分页查询全部商品
    @Select("select * from tb_goods limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectAllByPage(Integer currentPage,Integer pageSize);


    //获取商品总数（用于辅助分页）
    @Select("select count(*) from tb_goods")
    Integer getSum();


    //获取用户发布的商品总数（用于辅助分页）
    @Select("select count(*) from tb_goods where sellId=#{sellId}")
    Integer getSumByUser(Integer sellId);


    //根据商品类别分页查询
    @Select("select * from tb_goods where kindId=#{kindId} limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKind(Integer kingId,Integer currentPage,Integer pageSize);


    //获取当前类别的商品总数（用于辅助分页）
    @Select("select count(*) from tb_goods where kindId=#{kindId}")
    Integer getSumByKind(Integer kindId);


}

package com.usst.erhuo.dao;

import com.usst.erhuo.entity.Deal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DealDao {

    //新增一条交易中的交易
    @Insert("insert into tb_deal(userId,goodsId,flag) values(#{userId},#{goodsId},1)")
    Integer insert(Integer userId,Integer goodsId);

    //查单条交易
    @Select("select * from tb_deal where id=#{id}")
    Deal selectById(Integer id);

    //改变标志位
    @Update("update tb_deal set flag=#{flag} where id=#{id}")
    Integer updateFlag(Integer id,Integer flag);

    //根据买家id获取所有交易
    @Select("select * from tb_deal where flag in (1,2,3,0,6) and userId=#{userId} order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectAllByPurchaser(Integer userId,Integer currentPage,Integer pageSize);

    //根据买家id获取所有交易的数量
    @Select("select count(*) from tb_deal where flag in (1,2,3,0,6) and userId=#{userId}")
    Integer selectSumOfAllByPurchaser(Integer userId);

    //根据卖家id获取所有交易
    @Select("select tb_deal.id,tb_deal.userId,tb_deal.goodsId,tb_deal.flag from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag in (0,1,2,4,7) order by tb_deal.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectAllBySeller(Integer userId,Integer currentPage,Integer pageSize);

    //根据卖家id获取所有交易
    @Select("select count(*) from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag in (0,1,2,4,7)")
    Integer selectSumOfAllBySeller(Integer userId);

    //根据买家id获取交易中的交易
    @Select("select * from tb_deal where flag=1 and userId=#{userId} order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectDealingByPurchaser(Integer userId,Integer currentPage,Integer pageSize);

    //根据买家id获取交易中的交易
    @Select("select count(*) from tb_deal where flag=1 and userId=#{userId}")
    Integer selectSumOfDealingByPurchaser(Integer userId);

    //根据卖家id获取交易中的交易
    @Select("select tb_deal.id,tb_deal.userId,tb_deal.goodsId,tb_deal.flag from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag=1 order by tb_deal.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectDealingBySeller(Integer userId,Integer currentPage,Integer pageSize);

    //根据卖家id获取交易中的交易
    @Select("select count(*) from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag=1")
    Integer selectSumOfDealingBySeller(Integer userId);

    //根据买家id获取交易完成的交易
    @Select("select * from tb_deal where flag in (2,3) and userId=#{userId} order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectDoneByPurchaser(Integer userId,Integer currentPage,Integer pageSize);

    //根据买家id获取交易完成的交易
    @Select("select count(*) from tb_deal where flag in (2,3) and userId=#{userId}")
    Integer selectSumOfDoneByPurchaser(Integer userId);

    //根据卖家id获取交易完成的交易
    @Select("select tb_deal.id,tb_deal.userId,tb_deal.goodsId,tb_deal.flag from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag in (2,4) order by tb_deal.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectDoneBySeller(Integer userId,Integer currentPage,Integer pageSize);

    //根据卖家id获取交易完成的交易
    @Select("select count(*) from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag in (2,4)")
    Integer selectSumOfDoneBySeller(Integer userId);

    //根据买家id获取失败的交易
    @Select("select * from tb_deal where flag in (0,6) and userId=#{userId} order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectFailedByPurchaser(Integer userId,Integer currentPage,Integer pageSize);

    //根据买家id获取失败的交易
    @Select("select count(*) from tb_deal where flag in (0,6) and userId=#{userId}")
    Integer selectSumOfFailedByPurchaser(Integer userId);

    //根据卖家id获取失败的交易
    @Select("select tb_deal.id,tb_deal.userId,tb_deal.goodsId,tb_deal.flag from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag in (0,7) order by tb_deal.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Deal> selectFailedBySeller(Integer userId,Integer currentPage,Integer pageSize);

    //根据卖家id获取失败的交易
    @Select("select count(*) from tb_deal,tb_goods where tb_goods.sellId=#{userId} and tb_goods.id=tb_deal.goodsId and tb_deal.flag in (0,7)")
    Integer selectSumOfFailedBySeller(Integer userId);
}

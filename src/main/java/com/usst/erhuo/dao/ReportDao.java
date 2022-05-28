package com.usst.erhuo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportDao {

    @Insert("insert into tb_report(goodsId,userId,reason) values(#{goodsId},#{userId},#{reason})")
    Integer insertReport(Integer goodsId,Integer userId,String reason);


}

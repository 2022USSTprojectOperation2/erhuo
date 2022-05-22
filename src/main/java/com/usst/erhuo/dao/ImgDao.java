package com.usst.erhuo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImgDao {
    //给商品添加详细图片
    @Insert("insert into tb_img(goodsId,imgPath) values(#{goodsId},#{imgPath})")
    Integer insertImage(Integer goodsId,String imgPath);
}

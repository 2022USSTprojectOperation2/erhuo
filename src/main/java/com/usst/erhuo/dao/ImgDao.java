package com.usst.erhuo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgDao {
    //给商品添加详细图片
    @Insert("insert into tb_img(goodsId,imgPath) values(#{goodsId},#{imgPath})")
    Integer insertImage(Integer goodsId,String imgPath);

    @Select("select imgPath from tb_img where goodsId=#{goodsId}")
    List<String> selectImgPathByGoodsId(Integer goodsId);
}

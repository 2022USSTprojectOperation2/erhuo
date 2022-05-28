package com.usst.erhuo.dao;

import com.usst.erhuo.entity.Goods;
import com.usst.erhuo.entity.Kind;
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


    @Update("update tb_goods set flag=#{flag} where id=#{id}")
    Integer updateFlag(Integer id,Integer flag);

    //通过商品id查单个商品
    @Select("select * from tb_goods where id=#{id}")
    Goods selectById(Integer id);

    //通过封面图路径查商品id
    @Select("select id from tb_goods where imgPath=#{imgPath}")
    Integer selectIdByImgPath(String imgPath);

    //分页查询用户发布的商品
    @Select("select * from tb_goods where sellId=#{sellId} and flag=0 order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByUser(Integer sellId,Integer currentPage,Integer pageSize);


    //分页查询全部商品
    @Select("select * from tb_goods where flag=0 order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectAllByPage(Integer currentPage,Integer pageSize);


    //获取商品总数（用于辅助分页）
    @Select("select count(*) from tb_goods where flag=0")
    Integer getSum();


    //获取用户发布的商品总数（用于辅助分页）
    @Select("select count(*) from tb_goods where sellId=#{sellId} and flag=0")
    Integer getSumByUser(Integer sellId);


    //根据商品类别分页查询
    @Select("select * from tb_goods where kindId=#{kindId} and flag=0 order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKind(Integer kindId,Integer currentPage,Integer pageSize);


    //获取当前类别的商品总数（用于辅助分页）
    @Select("select count(*) from tb_goods where kindId=#{kindId} and flag=0")
    Integer getSumByKind(Integer kindId);

    //根据关键字搜索
    @Select("select * from tb_goods where goodsName like CONCAT('%',#{keyWord},'%') or introduction like CONCAT('%',#{keyWord},'%') order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKeyWord(String keyWord,Integer currentPage,Integer pageSize);

    //根据关键字获取个数
    @Select("select count(*) from tb_goods where goodsName like CONCAT('%',#{keyWord},'%') or introduction like CONCAT('%',#{keyWord},'%')")
    Integer getSumByKeyWord(String keyWord);

    //根据关键字和类别搜索
    @Select("select * from tb_goods where kindId=#{kindId} and (goodsName like CONCAT('%',#{keyWord},'%') or introduction like CONCAT('%',#{keyWord},'%') ) order by id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKindAndKeyWord(Integer kindId,String keyWord,Integer currentPage,Integer pageSize);

    //获取根据关键字和类别搜索的个数
    @Select("select count(*) from tb_goods where kindId=#{kindId} and (goodsName like CONCAT('%',#{keyWord},'%') or introduction like CONCAT('%',#{keyWord},'%') )")
    Integer getSumByKindAndKeyWord(Integer kindId,String keyWord);


    //以下添加按热度排序

    //分页查询全部商品
    @Select("select * from tb_goods where flag=0 order by likeLevel desc , id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectAllByPageOrderByLikeLevel(Integer currentPage,Integer pageSize);


    //根据商品类别分页查询
    @Select("select * from tb_goods where kindId=#{kindId} and flag=0 order by likeLevel desc , id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKindOrderByLikeLevel(Integer kindId,Integer currentPage,Integer pageSize);


    //根据关键字搜索
    @Select("select * from tb_goods where goodsName like CONCAT('%',#{keyWord},'%') or introduction like CONCAT('%',#{keyWord},'%') order by likeLevel desc , id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKeyWordOrderByLikeLevel(String keyWord,Integer currentPage,Integer pageSize);


    //根据关键字和类别搜索
    @Select("select * from tb_goods where kindId=#{kindId} and (goodsName like CONCAT('%',#{keyWord},'%') or introduction like CONCAT('%',#{keyWord},'%') ) order by likeLevel desc , id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Goods> selectByKindAndKeyWordOrderByLikeLevel(Integer kindId,String keyWord,Integer currentPage,Integer pageSize);


    //给商品增加热度值
    @Update("update tb_goods set likeLevel=likeLevel+1 where id=#{id}")
    Integer updateLikeLevel(Integer id);
}

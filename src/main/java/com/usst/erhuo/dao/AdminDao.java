package com.usst.erhuo.dao;

import com.usst.erhuo.vo.AdminDeal;
import com.usst.erhuo.vo.AdminGoods;
import com.usst.erhuo.vo.AdminReport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminDao {

    @Select("select id from tb_admin where name=#{name} and password=#{password}")
    Integer adminLogin(String name,String password);


    @Select("select D.id,G.price,goodsName,userName,userId,goodsId,kindName,D.flag \n" +
            "from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
            "left join tb_user as U on userId = U.id\n" +
            "left join tb_kind as K on kindId = K.id\n" +
            "order by D.id desc\n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminDeal> adminDeal(Integer currentPage, Integer pageSize);



    @Select("select count(*) from tb_deal")
    Integer getSum();



    @Select("select D.id,G.price,goodsName,userName,userId,goodsId,kindName,D.flag\n" +
            "            from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
            "            left join tb_user as U on userId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')\n" +
            "            order by D.id desc\n" +
            "            limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminDeal> getKeyDeal(Integer currentPage, Integer pageSize, String keyWord);

    @Select("select count(*) " +
            "            from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
            "            left join tb_user as U on userId = U.id\n" +
            " where goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')")
    Integer getKeyDealSum(String keyWord);



    @Select("select D.id,G.price,goodsName,userName,userId,goodsId,kindName,D.flag,kindId\n" +
                   "            from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
                   "            left join tb_user as U on userId = U.id\n" +
                   "            left join tb_kind as K on kindId = K.id\n" +
                   "            where kindId = #{kindId}\n" +
                   "            and goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')" +
                   "            order by D.id desc\n" +
                   "            limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminDeal> getKindKeyDeal(Integer currentPage, Integer pageSize, Integer kindId, String keyWord);

    @Select("select count(*) \n" +
            "            from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
            "            left join tb_user as U on userId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}\n" +
            "            and goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')")
    Integer getKindKeyDealSum(Integer kindId, String keyWord);



    @Select("select D.id,G.price,goodsName,userName,userId,goodsId,kindName,D.flag,kindId\n" +
            "            from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
            "            left join tb_user as U on userId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}\n" +
            "            order by D.id desc\n" +
            "            limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminDeal> getKindDeal(Integer currentPage, Integer pageSize, Integer kindId);

    @Select("select count(*) " +
            "            from tb_deal as D left join tb_goods as G on goodsId = G.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}")
    Integer getKindDealSum(Integer kindId);






    @Select("select D.id,price,goodsName,userName,sellId,kindName,D.flag \n" +
            "from tb_goods as D\n" +
            "left join tb_user as U on sellId = U.id\n" +
            "left join tb_kind as K on kindId = K.id\n" +
            "order by D.id desc\n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminGoods> adminGoods(Integer currentPage, Integer pageSize);



    @Select("select count(*) from tb_goods")
    Integer getGoodsSum();



    @Select("select D.id,price,goodsName,userName,sellId,kindName,D.flag\n" +
            "            from tb_goods as D \n" +
            "            left join tb_user as U on sellId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')\n" +
            "            order by D.id desc\n" +
            "            limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminGoods> getKeyGoods(Integer currentPage, Integer pageSize, String keyWord);

    @Select("select count(*) " +
            "            from tb_goods as D \n" +
            "            left join tb_user as U on sellId = U.id\n" +
            " where goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')")
    Integer getKeyGoodsSum(String keyWord);



    @Select("select D.id,price,goodsName,userName,sellId,kindName,D.flag,kindId\n" +
            "            from tb_goods as D \n" +
            "            left join tb_user as U on sellId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}\n" +
            "            and goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')" +
            "            order by D.id desc\n" +
            "            limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminGoods> getKindKeyGoods(Integer currentPage, Integer pageSize, Integer kindId, String keyWord);

    @Select("select count(*) \n" +
            "            from tb_goods as D\n" +
            "            left join tb_user as U on sellId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}\n" +
            "            and goodsName like CONCAT('%',#{keyWord},'%') or userName like CONCAT('%',#{keyWord},'%')")
    Integer getKindKeyGoodsSum(Integer kindId, String keyWord);



    @Select("select D.id,price,goodsName,userName,sellId,kindName,D.flag,kindId\n" +
            "            from tb_goods as D \n" +
            "            left join tb_user as U on sellId = U.id\n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}\n" +
            "            order by D.id desc\n" +
            "            limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<AdminGoods> getKindGoods(Integer currentPage, Integer pageSize, Integer kindId);

    @Select("select count(*) " +
            "            from tb_goods as D \n" +
            "            left join tb_kind as K on kindId = K.id\n" +
            "            where kindId = #{kindId}")
    Integer getKindGoodsSum(Integer kindId);


    @Select("select R.id,goodsId,reason,goodsName,userName,userId from tb_report as R\n" +
            "left join tb_goods as G on  G.id = goodsId\n" +
            "left join tb_user as U on U.id = userId\n" +
            "where G.flag = 3;")
    List<AdminReport> adminReport(Integer currentPage, Integer pageSize);

    @Select("select count(*) from tb_report as R\n" +
            "left join tb_goods as G on  G.id = goodsId\n" +
            "left join tb_user as U on U.id = userId\n" +
            "where G.flag = 3;")
    Integer getReportSum();


    @Update("update tb_goods set flag = 4 where id = #{id}")
    void downReport(Integer id);

    @Update("update tb_goods set flag = 0 where id = #{id}")
    void cancelReport(Integer id);

    @Delete("delete from tb_report where goodsId = #{id}")
    void deleReport(Integer id);

}

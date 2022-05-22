package com.usst.erhuo.dao;

import com.usst.erhuo.entity.Kind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KindDao {

    @Select("select * from tb_kind")
    List<Kind> selectAll();
}

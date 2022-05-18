package com.usst.erhuo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usst.erhuo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from tb_user")
    List<User> getAllUser();
}

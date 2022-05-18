package com.usst.erhuo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usst.erhuo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao extends BaseMapper<User> {

    //测试用
    @Select("select * from tb_user")
    List<User> getAllUser();


    //登录验证
    @Select("select count(*) from tb_user where userName=#{userName} and password=#{password}")
    Integer userLogin(String userName,String password);


}

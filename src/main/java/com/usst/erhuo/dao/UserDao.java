package com.usst.erhuo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usst.erhuo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface UserDao{

    //测试用
    @Select("select * from tb_user")
    List<User> getAllUser();

    //登录验证
    @Select("select id from tb_user where userName=#{userName} and password=#{password}")
    Integer userLogin(String userName,String password);


    //验证注册时用户名唯一
    @Select("select count(*) from tb_user where userName=#{userName}")
    Integer checkUserName(String userName);


    //用户注册
    @Insert("insert into tb_user(userName,password,phone,headImgPath) values (#{userName},#{password},#{phone},#{headImgPath})")
    void userRegister(String userName,String password,String phone,String headImgPath);


    //用户修改密码
    @Update("update tb_user set password = #{password} where id = #{id}")
    void changePassword(String password,Integer id);


    //获取用户信息
    @Select("select userName,phone,headImgPath,exp,introduction,grade,major,address from tb_user where id = #{id}")
    User getUserInfo(Integer id);


    //用户修改信息
    @Update("update tb_user set phone =#{phone},introduction=#{introduction},grade=#{grade},major=#{major},address=#{address} where id =#{id}")
    void changeUserInfo(User user);


    //用户修改头像
    @Update("update tb_user set headImgPath = #{headImgPath} where id = #{id}")
    void changeUserImg(String headImgPath,Integer id);


    //用户涨经验
    @Update("update tb_user set exp= #{exp} where id=#{id}")
    void addExp(Integer exp,Integer id);





}

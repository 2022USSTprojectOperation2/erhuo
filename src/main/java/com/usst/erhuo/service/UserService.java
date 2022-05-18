package com.usst.erhuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usst.erhuo.entity.User;

import java.util.List;



public interface UserService {

    //测试用
    List<User> getAllUser();

    //登录验证
    Integer userLogin(String userName,String password);

    //验证注册时用户名是否唯一
    Integer checkUserLogin(String userName);

    //用户注册
    void userRegister(String userName,String password,String phone);

}

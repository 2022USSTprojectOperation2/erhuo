package com.usst.erhuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usst.erhuo.entity.User;

import java.util.List;



public interface UserService {

    //测试用
    List<User> getAllUser();



    //登录验证
    Integer userLogin(String userName,String password);


}

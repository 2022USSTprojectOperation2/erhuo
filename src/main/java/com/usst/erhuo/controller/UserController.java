package com.usst.erhuo.controller;


import com.usst.erhuo.entity.User;
import com.usst.erhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    //测试用
    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }


    //用户登录
    @RequestMapping("/login")
    public Integer userLogin(String userName,String password){
        return userService.userLogin(userName,password);
    }


    //验证注册时用户名是否唯一

    @RequestMapping("/checkUser")
    public Integer checkUserName(String userName){
        return userService.checkUserLogin(userName);
    }



    //用户注册
    @RequestMapping("/register")
    public Integer userRegister(String username,String password){

        return null;
    }



}

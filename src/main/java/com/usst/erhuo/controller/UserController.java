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
    public Integer userLogin(String userName,String password,HttpSession session){
        Integer userId = userService.userLogin(userName,password);
        if(userId!=null) session.setAttribute("userId",userId);
        return userId;
    }

    //验证注册时用户名是否唯一
    @RequestMapping("/checkUser")
    public Integer checkUserName(String userName){
        return userService.checkUserLogin(userName);
    }

    //用户注册
    @RequestMapping("/register")
    public Integer userRegister(String userName,String password,String phone,HttpSession session){
        userService.userRegister(userName,password,phone);
        Integer userId = userService.userLogin(userName,password);
        session.setAttribute("userId",userId);
        return userId;
    }

    //密码修改
    @RequestMapping("changePassword")
    public void changePassword(String password,HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        userService.changePassword(password,userId);
    }


    //获取用户信息
    @RequestMapping("getUserInfo")
    public User getUserInfo(HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        return userService.getUserInfo(userId);
    }

    //修改用户信息
    @RequestMapping("changeUserInfo")
    public void changeUserInfo(String phone,String introduction,String grade,String major,String address,HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        User user=new User();
        user.setId(userId);
        user.setPhone(phone);
        user.setIntroduction(introduction);
        user.setGrade(grade);
        user.setMajor(major);
        user.setAddress(address);
        userService.changeUserInfo(user);
    }


    //修改用户头像
    @RequestMapping("changeUserImg")
    public void changeUserImg(HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        //获取图片
    }


}

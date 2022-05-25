package com.usst.erhuo.controller;


import com.usst.erhuo.entity.User;
import com.usst.erhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
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
    public Integer userLogin(@RequestBody User user, HttpSession session){
        Integer userId = userService.userLogin(user.getUserName(),user.getPassword());
        if(userId!=null) session.setAttribute("userId",userId);
        return userId;
    }

    //验证注册时用户名是否唯一
    @RequestMapping("/checkUser/{userName}")
    public Integer checkUserName(@PathVariable String userName){
        return userService.checkUserLogin(userName);
    }

    //用户注册
    @RequestMapping("/register")
    public Integer userRegister(@RequestBody User user,HttpSession session){
        userService.userRegister(user.getUserName(),user.getPassword(),user.getPhone());
        Integer userId = userService.userLogin(user.getUserName(),user.getPassword());
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
    public void changeUserInfo(@RequestBody User user,HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        user.setId(userId);
        userService.changeUserInfo(user);
    }


    //修改用户头像
    @RequestMapping("changeUserImg")
    public void changeUserImg(HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        //获取图片
    }


    //用户涨经验
    @RequestMapping("addExp")
    public void addExp(Integer exp,HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        userService.addExp(exp,userId);

    }

}

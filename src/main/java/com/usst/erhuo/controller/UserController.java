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

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}

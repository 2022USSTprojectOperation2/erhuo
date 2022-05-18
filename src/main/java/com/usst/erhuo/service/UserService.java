package com.usst.erhuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usst.erhuo.entity.User;

import java.util.List;



public interface UserService {

    List<User> getAllUser();
}

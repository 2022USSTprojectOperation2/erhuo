package com.usst.erhuo.service.impl;

import com.usst.erhuo.dao.UserDao;
import com.usst.erhuo.entity.User;
import com.usst.erhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}

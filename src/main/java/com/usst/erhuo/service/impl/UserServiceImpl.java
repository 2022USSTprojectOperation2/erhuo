package com.usst.erhuo.service.impl;

import com.usst.erhuo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDao userDao;


}

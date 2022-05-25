package com.usst.erhuo.service.impl;


import com.usst.erhuo.dao.AdminDao;
import com.usst.erhuo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    public Integer adminLogin(String name,String password) {
        return adminDao.adminLogin(name,password);
    }
}

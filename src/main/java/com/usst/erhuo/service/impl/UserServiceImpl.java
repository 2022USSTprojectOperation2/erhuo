package com.usst.erhuo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    //测试用
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    //用户登录
    @Override
    public Integer userLogin(String userName,String password) {
        return userDao.userLogin(userName,password);
    }

    //验证注册时用户名是否唯一
    @Override
    public Integer checkUserLogin(String userName) {
        return userDao.checkUserName(userName);
    }

    //用户注册
    @Override
    public void userRegister(String userName, String password, String phone) {
        String headImgPath="img/headImg/defaultIcon.png";
        userDao.userRegister(userName,password,phone,headImgPath);
    }

    //密码修改
    @Override
    public void changePassword(String password, Integer userId) {
        userDao.changePassword(password,userId);
    }



    //获取用户信息
    @Override
    public User getUserInfo(Integer id) {
        return userDao.getUserInfo(id);
    }

    @Override
    public void changeUserInfo(User user) {
        userDao.changeUserInfo(user);
    }

    @Override
    public void changeUserImg(String headImgPath, Integer id) {
        //保存图片
        //生成图片路径

    }


}

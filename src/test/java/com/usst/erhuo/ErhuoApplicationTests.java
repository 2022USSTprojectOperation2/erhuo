package com.usst.erhuo;

import com.usst.erhuo.controller.UserController;
import com.usst.erhuo.dao.GoodsDao;
import com.usst.erhuo.dao.UserDao;
import com.usst.erhuo.entity.User;
import com.usst.erhuo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

@SpringBootTest
class ErhuoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    UserController userController;


    
    @Test
    void testUser(){
//        User user=new User();
//        user.setId(1);
//        user.setPhone("phone");
//        user.setIntroduction("phone");
//        user.setGrade("phone");
//        user.setMajor("phone");
//        user.setAddress("phone");

        //userService.changeUserInfo(user);
        userService.addExp(5,1);

    }

    @Test
    void changeUserInfo(){
        User userInfo = userDao.getUserInfo(1);
        userInfo.setId(1);
        userInfo.setMajor("jsj");
        userService.changeUserInfo(userInfo);
    }


}

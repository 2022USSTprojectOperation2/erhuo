package com.usst.erhuo;

import com.usst.erhuo.controller.UserController;
import com.usst.erhuo.dao.UserDao;
import com.usst.erhuo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println(userController.getAllUser());
    }

}

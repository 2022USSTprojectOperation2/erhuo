package com.usst.erhuo.controller;


import com.usst.erhuo.entity.Admin;
import com.usst.erhuo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public Integer userLogin(@RequestBody Admin admin, HttpSession session){
        Integer id = adminService.adminLogin(admin.getName(),admin.getPassword());
        if(id!=null) session.setAttribute("adminId",id);
        return id;
    }


}

package com.usst.erhuo.controller;

import com.usst.erhuo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    //添加封面
    @RequestMapping("/cover")
    public String addCover(@RequestPart("file") MultipartFile file,HttpSession session){
        Integer userId=(Integer) session.getAttribute("userId");
        return imageService.addCover(file,userId);
    }

    //添加详情图
    @RequestMapping("/details")
    public String addDetails(@RequestPart("file") MultipartFile file,HttpSession session){
        Integer userId=(Integer) session.getAttribute("userId");
        return imageService.addDetails(file,userId);
    }

}

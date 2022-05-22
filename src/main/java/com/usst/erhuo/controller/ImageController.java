package com.usst.erhuo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/imgs")
public class ImageController {
    @Value("${img-path}")
    private String uploadPath;

    @RequestMapping("/cover")
    public void addCover(@RequestPart("file")MultipartFile file){
        String fileName=file.getOriginalFilename();
        String visibleUri="/"+fileName;
        String saveUri=uploadPath+"cover/"+fileName;
        File saveFile=new File(saveUri);
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

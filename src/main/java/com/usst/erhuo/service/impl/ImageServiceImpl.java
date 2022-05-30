package com.usst.erhuo.service.impl;

import com.usst.erhuo.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${img-path.target")
    private String targetPath;

    @Value("${img-path.local}")
    private String localPath;

    @Value("${img-path.server}")
    private String serverPath;

    private String getUserDir(){
        return System.getProperty("user.dir");
    }

    @Override
    public String addCover(MultipartFile file, Integer userId) {
        String fileName=getFileName(file.getOriginalFilename());
        File path= null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!path.exists()){
            path=new File("");
        }
        File upLoad=new File(path.getAbsolutePath(),"static/img/cover/"+userId+"/"+fileName);
        if(!upLoad.exists()){
            upLoad.mkdirs();
        }
        String visibleUri=serverPath+"cover/"+userId+"/"+fileName;
        try {
            file.transferTo(upLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }

    @Override
    public String addDetails(MultipartFile file, Integer userId) {
        String fileName=getFileName(file.getOriginalFilename());
        File path= null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!path.exists()){
            path=new File("");
        }
        File upLoad=new File(path.getAbsolutePath(),"static/img/details/"+userId+"/"+fileName);
        if(!upLoad.exists()){
            upLoad.mkdirs();
        }
        String visibleUri=serverPath+"details/"+userId+"/"+fileName;
        try {
            file.transferTo(upLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }

    private String getFileName(String originalName){
        System.out.println(originalName);
        return UUID.randomUUID().toString()+"_"+originalName;
    }
}

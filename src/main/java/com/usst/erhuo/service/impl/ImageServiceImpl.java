package com.usst.erhuo.service.impl;

import com.usst.erhuo.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${img-path.local}")
    private String localPath;

    @Value("${img-path.server}")
    private String serverPath;

    @Override
    public String addCover(MultipartFile file, Integer userId) {
        String fileName=getFileName(file.getOriginalFilename());
        String visibleUri=serverPath+"cover/"+userId+"/"+fileName;
        String saveUri=localPath+"cover/"+userId+"/"+fileName;
        File saveFile=new File(saveUri);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }

    @Override
    public String addDetails(MultipartFile file, Integer userId) {
        String fileName=getFileName(file.getOriginalFilename());
        String visibleUri=serverPath+"details/"+userId+"/"+fileName;
        String saveUri=localPath+"details/"+userId+"/"+fileName;
        File saveFile=new File(saveUri);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }

    private String getFileName(String originalName){
        return UUID.randomUUID().toString()+"_"+originalName;
    }
}

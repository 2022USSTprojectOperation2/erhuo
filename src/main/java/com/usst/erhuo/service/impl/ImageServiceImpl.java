package com.usst.erhuo.service.impl;

import com.usst.erhuo.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
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

    @Override
    public String addCover(MultipartFile file, Integer userId) {
        String fileName=getFileName(file.getOriginalFilename());
        String visibleUri=serverPath+"cover/"+userId+"/"+fileName;
        String localUri=localPath+"cover/"+userId+"/"+fileName;
        File localFile=new File(localUri);
        if(!localFile.exists()){
            localFile.mkdirs();
        }
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String targetUri=targetPath+"cover/"+userId+"/"+fileName;
//        File targetFile=new File(targetUri);
//        if(!targetFile.exists()){
//           targetFile.mkdirs();
//        }
//        try {
//            file.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return visibleUri;
    }

    @Override
    public String addDetails(MultipartFile file, Integer userId) {
        String fileName=getFileName(file.getOriginalFilename());
        String visibleUri=serverPath+"details/"+userId+"/"+fileName;
        String localUri=localPath+"details/"+userId+"/"+fileName;
        File localFile=new File(localUri);
        if(!localFile.exists()){
            localFile.mkdirs();
        }
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String targetUri=targetPath+"details/"+userId+"/"+fileName;
//        File targetFile=new File(targetUri);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        try {
//            file.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return visibleUri;
    }

    private String getFileName(String originalName){
        return UUID.randomUUID().toString()+"_"+originalName;
    }
}

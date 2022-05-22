package com.usst.erhuo.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String addCover(MultipartFile file,Integer userId);
    String addDetails(MultipartFile file,Integer userId);
}

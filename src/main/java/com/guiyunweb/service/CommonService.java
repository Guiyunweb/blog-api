package com.guiyunweb.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CommonService {
    String uploadImages(MultipartFile file) throws IOException;
}

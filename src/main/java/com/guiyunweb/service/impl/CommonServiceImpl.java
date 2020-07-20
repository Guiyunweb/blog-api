package com.guiyunweb.service.impl;

import com.guiyunweb.service.CommonService;
import com.guiyunweb.utils.DateUtils;
import com.guiyunweb.utils.obs.huaweicloud.ObsUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class CommonServiceImpl implements CommonService {


    @Override
    public String uploadImages(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String path = DateUtils.getDateString(new Date(),"yyyy/MM/dd/");
        String name = System.currentTimeMillis()+"."+prefix;
        ObsUtils.upload(file.getInputStream(),path+name);
        return path+name;
    }
}

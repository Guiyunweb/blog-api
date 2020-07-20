package com.guiyunweb.controller;

import com.guiyunweb.model.support.BaseResponse;
import com.guiyunweb.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    CommonService service;

    @RequestMapping(value = "/upload", produces = "application/json; charset=utf-8")
    public BaseResponse pushImages(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        return BaseResponse.successString(service.uploadImages(file));
    }

}

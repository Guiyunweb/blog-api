package com.guiyunweb.controller;

import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.support.BaseResponse;
import com.guiyunweb.service.PostsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    PostsSerivce serivce;

    @RequestMapping("/save")
    public BaseResponse<Object> save(@RequestBody PostArticle article){
        serivce.save(article);
        return BaseResponse.success("保存成功");
    }

}

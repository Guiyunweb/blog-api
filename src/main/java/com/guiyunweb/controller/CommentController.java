package com.guiyunweb.controller;

import com.guiyunweb.model.entity.PostComment;
import com.guiyunweb.model.support.BaseResponse;
import com.guiyunweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService service;

    @RequestMapping("/save")
    public BaseResponse save(@RequestBody PostComment postComment){
        service.save(postComment);
        return BaseResponse.success("添加成功");
    }

    @GetMapping("/show")
    public List<PostComment> show(String id){
        return service.show(id);
    }

}

package com.guiyunweb.controller;

import com.guiyunweb.model.dto.PageDTO;
import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.support.BaseResponse;
import com.guiyunweb.service.PostsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    public Page<PostArticle> list(PageDTO dto, PostArticle article){
        return serivce.getList(article,dto);
    }

    @GetMapping("/getInfo")
    public PostArticle getInfo(String id){
        return serivce.getInfo(id);
    }

    @GetMapping("/del")
    public BaseResponse del(PostArticle article){
         serivce.del(article);
         return BaseResponse.success("删除成功");
    }

    @GetMapping("/showList")
    public Page<PostArticle> showList(PageDTO dto, PostArticle article){
        return serivce.showList(article,dto);
    }

}

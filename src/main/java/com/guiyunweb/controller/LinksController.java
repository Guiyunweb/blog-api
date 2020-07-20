package com.guiyunweb.controller;

import com.guiyunweb.model.entity.PostLinks;
import com.guiyunweb.model.support.BaseResponse;
import com.guiyunweb.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common")
public class LinksController {

    @Autowired
    LinksService service;

    @RequestMapping("/save")
    public BaseResponse save(@RequestBody PostLinks links){
        service.save(links);
        return BaseResponse.success("添加成功");
    }

    @RequestMapping("/list")
    public List<PostLinks> list(@RequestBody PostLinks links){
        return service.list();
    }

    @RequestMapping("/showList")
    public List<PostLinks> showList(@RequestBody PostLinks links){
        return service.showList();
    }
}

package com.guiyunweb.controller;

import com.guiyunweb.model.entity.PostMenu;
import com.guiyunweb.model.support.BaseResponse;
import com.guiyunweb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService service;

    @RequestMapping("/add")
    public BaseResponse menu(@RequestBody PostMenu postMenu){
        service.save(postMenu);
        return BaseResponse.success("保存成功");
    }

    @GetMapping
    public List<PostMenu> getPostMenu(){
        return service.getPostMenu();
    }


}

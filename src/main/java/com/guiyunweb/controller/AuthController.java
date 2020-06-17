package com.guiyunweb.controller;

import com.guiyunweb.model.entity.PostsUsers;
import com.guiyunweb.model.vo.LoginVO;
import com.guiyunweb.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证控制器
 *
 * @author wnkj
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

    @RequestMapping("/login")
    public LoginVO login(@RequestBody PostsUsers users) {
        return service.login(users);
    }

    @RequestMapping("/registered")
    public LoginVO registered(@RequestBody PostsUsers users) {
        return service.registered(users);
    }

}

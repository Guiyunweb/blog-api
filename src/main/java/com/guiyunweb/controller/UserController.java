package com.guiyunweb.controller;

import com.guiyunweb.model.vo.LoginVO;
import com.guiyunweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wnkj
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/info")
    public LoginVO info() {
        return service.info();
    }

}

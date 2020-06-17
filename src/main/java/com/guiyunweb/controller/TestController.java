package com.guiyunweb.controller;

import com.guiyunweb.model.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wnkj
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public Test hello() {
        return new Test("sss");
    }
}

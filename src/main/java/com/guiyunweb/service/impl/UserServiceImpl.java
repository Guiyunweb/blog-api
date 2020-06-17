package com.guiyunweb.service.impl;

import com.guiyunweb.model.vo.LoginVO;
import com.guiyunweb.service.UserService;
import com.guiyunweb.utils.RedisUtils;
import com.guiyunweb.utils.UsersUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wnkj
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisUtils redisUtils;

    @Override
    public LoginVO info() {
        String id = (String) SecurityUtils.getSubject().getPrincipal();
        return redisUtils.get(id, LoginVO.class);
    }
}

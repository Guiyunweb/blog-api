package com.guiyunweb.service;

import com.guiyunweb.model.entity.PostsUsers;
import com.guiyunweb.model.vo.LoginVo;

/**
 * @author wnkj
 */
public interface AuthService {
    LoginVo login(PostsUsers users);

    LoginVo registered(PostsUsers users);
}

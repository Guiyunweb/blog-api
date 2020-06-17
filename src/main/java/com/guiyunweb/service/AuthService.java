package com.guiyunweb.service;

import com.guiyunweb.model.entity.PostsUsers;
import com.guiyunweb.model.vo.LoginVO;

/**
 * @author wnkj
 */
public interface AuthService {
    LoginVO login(PostsUsers users);

    LoginVO registered(PostsUsers users);
}

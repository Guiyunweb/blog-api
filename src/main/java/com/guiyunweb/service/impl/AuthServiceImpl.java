package com.guiyunweb.service.impl;

import com.guiyunweb.exception.AuthException;
import com.guiyunweb.model.entity.PostsUsers;
import com.guiyunweb.model.vo.LoginVo;
import com.guiyunweb.repository.PostUsersRepository;
import com.guiyunweb.service.AuthService;
import com.guiyunweb.utils.JwtUtils;
import com.guiyunweb.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author wnkj
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    PostUsersRepository repository;

    @Autowired
    RedisUtils redisUtils;

    @Override
    public LoginVo login(PostsUsers users) {
        if (ObjectUtils.isEmpty(users)) {
            throw new AuthException("用户名或密码不能为空");
        }
        if (StringUtils.isEmpty(users.getUsername())) {
            throw new AuthException("用户名不能为空");
        }
        if (StringUtils.isEmpty(users.getPassword())) {
            throw new AuthException("密码不能为空");
        }
        PostsUsers postsUsers = repository.findByUsername(users.getUsername());
        if ((!ObjectUtils.isEmpty(postsUsers)) && (postsUsers.getPassword().equals(users.getPassword()))) {
            LoginVo vo = new LoginVo(postsUsers);
            vo.setToken(JwtUtils.createToken(vo.getId(), vo));
            redisUtils.add(vo.getId(), vo);
            return vo;
        } else {
            throw new AuthException("用户名或者密码错误");
        }
    }


    @Override
    public LoginVo registered(PostsUsers users) {
        if (ObjectUtils.isEmpty(users)) {
            throw new AuthException("用户名或密码不能为空");
        }
        if (StringUtils.isEmpty(users.getUsername())) {
            throw new AuthException("用户名不能为空");
        }
        if (StringUtils.isEmpty(users.getPassword())) {
            throw new AuthException("密码不能为空");
        }
        PostsUsers postsUsers = repository.findByUsername(users.getUsername());
        if (!ObjectUtils.isEmpty(postsUsers)) {
            throw new AuthException("用户名已被注册");
        }
        repository.save(users);
        return login(users);
    }

}

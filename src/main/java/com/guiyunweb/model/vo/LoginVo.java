package com.guiyunweb.model.vo;

import com.guiyunweb.model.entity.PostsUsers;

/**
 * @author wnkj
 */
public class LoginVo {

    public LoginVo(PostsUsers users) {
        setId(users.getId());
        setUsername(users.getUsername());
    }

    private String id;

    private String username;

    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

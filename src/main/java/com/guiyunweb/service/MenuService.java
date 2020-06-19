package com.guiyunweb.service;

import com.guiyunweb.model.entity.PostMenu;

import java.util.List;

public interface MenuService {
    void save(PostMenu postMenu);

    List<PostMenu> getPostMenu();
}

package com.guiyunweb.service.impl;

import com.guiyunweb.model.entity.PostMenu;
import com.guiyunweb.repository.PostMenuRepository;
import com.guiyunweb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    PostMenuRepository repository;

    @Override
    public void save(PostMenu postMenu) {
        repository.save(postMenu);
    }

    @Override
    public List<PostMenu> getPostMenu() {
        return repository.findAll();
    }

}

package com.guiyunweb.service.impl;

import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.repository.PostArticleRepository;
import com.guiyunweb.service.PostsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsSerivce {

    @Autowired
    PostArticleRepository repository;

    @Override
    public void save(PostArticle article) {
        repository.save(article);
    }
}

package com.guiyunweb.service.impl;

import com.guiyunweb.model.dto.PageDTO;
import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.repository.PostArticleRepository;
import com.guiyunweb.service.PostsSerivce;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class PostsServiceImpl implements PostsSerivce {

    @Autowired
    PostArticleRepository repository;

    @Override
    public void save(PostArticle article) {
        if (StringUtils.isEmpty(article.getId())) {
            article.setAccess(0);
            article.setComments(false);
            article.setCreateTime(new Date());
        }
        repository.save(article);
    }

    @Override
    public Page<PostArticle> getList(PostArticle article, PageDTO dto) {
        if (ObjectUtils.isArray(dto)){
            dto = new PageDTO();
        }
        return repository.findAll(dto.getPageable());
    }

    @Override
    public PostArticle getInfo(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void del(PostArticle article) {
        repository.delete(article);
    }

    @Override
    public Page<PostArticle> showList(PostArticle article, PageDTO dto) {
        if (ObjectUtils.isArray(dto)){
            dto = new PageDTO();
        }
        return repository.findAllByRelease(true,dto.getPageable());
    }
}

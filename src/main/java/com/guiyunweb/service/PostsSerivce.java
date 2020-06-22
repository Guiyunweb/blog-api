package com.guiyunweb.service;

import com.guiyunweb.model.dto.PageDTO;
import com.guiyunweb.model.entity.PostArticle;
import org.springframework.data.domain.Page;

public interface PostsSerivce {
    void save(PostArticle article);

    Page<PostArticle> getList(PostArticle article, PageDTO dto);
}

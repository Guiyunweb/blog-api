package com.guiyunweb.service;

import com.guiyunweb.model.dto.PageDTO;
import com.guiyunweb.model.entity.PostArticle;
import org.springframework.data.domain.Page;

public interface PostsSerivce {
    void save(PostArticle article);

    Page<PostArticle> getList(PostArticle article, PageDTO dto);

    PostArticle getInfo(String id);

    void del(PostArticle article);

    Page<PostArticle> showList(PostArticle article, PageDTO dto);
}

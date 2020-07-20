package com.guiyunweb.service;

import com.guiyunweb.model.dto.PageDTO;
import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.vo.ArchiveVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostsSerivce {
    void save(PostArticle article);

    Page<PostArticle> getList(PostArticle article, PageDTO dto);

    PostArticle getInfo(String id);

    void del(PostArticle article);

    Page<PostArticle> showList(PostArticle article, PageDTO dto);

    List<ArchiveVO> archive();
}

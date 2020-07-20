package com.guiyunweb.service;

import com.guiyunweb.model.entity.PostLinks;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LinksService {
    void save(PostLinks links);

    List<PostLinks> list();

    List<PostLinks> showList();
}

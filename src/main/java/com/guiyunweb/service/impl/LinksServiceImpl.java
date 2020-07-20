package com.guiyunweb.service.impl;

import com.guiyunweb.model.entity.PostLinks;
import com.guiyunweb.repository.LinksRepository;
import com.guiyunweb.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinksServiceImpl implements LinksService {

    @Autowired
    LinksRepository repository;

    @Override
    public void save(PostLinks links) {
        repository.save(links);
    }

    @Override
    public List<PostLinks> list() {
        return repository.findAll();
    }

    @Override
    public List<PostLinks> showList() {
        return repository.findByShow(true);
    }
}

package com.guiyunweb.service.impl;

import com.guiyunweb.model.entity.PostComment;
import com.guiyunweb.repository.PostCommentRepository;
import com.guiyunweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostCommentRepository repository;

    @Override
    public PostComment save(PostComment postComment) {
        return repository.save(postComment);
    }

    @Override
    public List<PostComment> show(String id) {
       List<PostComment> list =  repository.findByArticleId(id);
        return list;
    }
}

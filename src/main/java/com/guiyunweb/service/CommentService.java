package com.guiyunweb.service;

import com.guiyunweb.model.entity.PostComment;

import java.util.List;

public interface CommentService {
    PostComment save(PostComment postComment);

    List<PostComment> show(String id);
}

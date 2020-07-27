package com.guiyunweb.repository;

import com.guiyunweb.model.entity.PostComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wnkj
 */
@Repository
public interface PostCommentRepository extends MongoRepository<PostComment, String> {

    List<PostComment> findByArticleId(String id);

}

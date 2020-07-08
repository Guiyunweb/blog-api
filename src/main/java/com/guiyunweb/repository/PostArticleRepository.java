package com.guiyunweb.repository;

import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.entity.PostMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wnkj
 */
@Repository
public interface PostArticleRepository extends MongoRepository<PostArticle, String> {

    Page<PostArticle> findAllByIssued(Boolean isRelease,Pageable pageable);
}

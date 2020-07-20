package com.guiyunweb.repository;

import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.entity.PostLinks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wnkj
 */
@Repository
public interface LinksRepository extends MongoRepository<PostLinks, String> {

    List<PostLinks> findByShow(Boolean show);
}

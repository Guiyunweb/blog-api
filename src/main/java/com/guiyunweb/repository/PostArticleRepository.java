package com.guiyunweb.repository;

import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.entity.PostMenu;
import com.guiyunweb.model.vo.ShowArticleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wnkj
 */
@Repository
public interface PostArticleRepository extends MongoRepository<PostArticle, String> {

    Page<ShowArticleVO> findByIssued(Boolean issued, Pageable pageable);
}

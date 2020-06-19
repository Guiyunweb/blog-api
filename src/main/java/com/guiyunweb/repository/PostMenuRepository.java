package com.guiyunweb.repository;

import com.guiyunweb.model.entity.PostMenu;
import com.guiyunweb.model.entity.PostsUsers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wnkj
 */
@Repository
public interface PostMenuRepository extends MongoRepository<PostMenu, String> {
}

package com.guiyunweb.repository;

import com.guiyunweb.model.entity.PostsUsers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wnkj
 */
@Repository
public interface PostUsersRepository extends MongoRepository<PostsUsers,String> {

    /**
     *  wae
     * @param username
     * @return
     */
    PostsUsers findByUsername(String username);

}

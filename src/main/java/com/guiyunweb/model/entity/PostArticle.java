package com.guiyunweb.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author wnkj
 */
@Document(value = "post_article")
@Data
public class PostArticle {

    @Id
    private String id;

    private String title;

    private String content;

    private String thumbnail;

    private String summary;

    private Integer access;

    private String comments;



}

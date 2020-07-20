package com.guiyunweb.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 友链
 */
@Document(value = "post_links")
@Data
public class PostLinks {

    @Id
    private String id;

    private String name;

    private String link;

    private String describe;

    private String cover;

    private Boolean show;

}

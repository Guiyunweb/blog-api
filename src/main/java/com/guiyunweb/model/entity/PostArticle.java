package com.guiyunweb.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author wnkj
 */
@Document(value = "post_article")
@Data
public class PostArticle {

    @Id
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 访问人数
     */
    private Integer access;

    /**
     * 评论
     */
    private boolean comments;

    /**
     * 是否发布
     */
    private boolean issued;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}

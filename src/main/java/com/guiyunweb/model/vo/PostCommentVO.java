package com.guiyunweb.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostCommentVO {

    private String id;

    /**
     * 文章Id
     */
    private String articleId;

    /**
     * 评论
     */
    private String comment;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 用户网站
     */
    private String site;

    /**
     * 父类ID
     */
    private String fatherId;

    /**
     * 创建时间
     */
    private Date createDate;


    private List<PostCommentVO> childList;
}

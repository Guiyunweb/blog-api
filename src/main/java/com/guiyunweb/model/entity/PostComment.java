package com.guiyunweb.model.entity;

import com.guiyunweb.model.vo.PostCommentVO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(value = "post_comment")
@Data
public class PostComment {

    @Id
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

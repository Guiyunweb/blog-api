package com.guiyunweb.model.vo;

import lombok.Data;

@Data
public class ShowArticleVO {

    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 缩略图
     */
    private String thumbnail;
}

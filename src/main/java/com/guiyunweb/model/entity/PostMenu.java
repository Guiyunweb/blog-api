package com.guiyunweb.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 菜单表
 */
@Document(value = "post_menu")
@Data
public class PostMenu {
    @Id
    private String id;
    private String path;
    private String title;
    private String icon;
    private String iconSvg;
    private PostMenu[] children;
}

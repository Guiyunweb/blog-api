package com.guiyunweb.model.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author wnkj
 */
@Data
public class UserVO {

    @Id
    private String id;
    /**
     * 用户名
     */
    private String username;

    private String password;

    private String email;

    private Integer status;

    private String city;

    private String lastLoginIp;

    private Date lastTime;

    private String about;

}

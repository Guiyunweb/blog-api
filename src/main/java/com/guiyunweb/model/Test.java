package com.guiyunweb.model;

import lombok.Data;

/**
 * @author wnkj
 */
@Data
public class Test {

    private String title;

    public Test(String title) {
        this.title = title;
    }
}

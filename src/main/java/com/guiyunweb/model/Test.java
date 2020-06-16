package com.guiyunweb.model;

import lombok.Data;

/**
 * @author wnkj
 */
@Data
public class Test {

    public Test(String title) {
        this.title = title;
    }

    private String title;
}

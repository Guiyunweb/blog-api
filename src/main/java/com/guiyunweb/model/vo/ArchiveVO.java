package com.guiyunweb.model.vo;

import com.guiyunweb.model.entity.PostArticle;

import java.util.List;

public class ArchiveVO {

    private Integer year;

    private List<PostArticle> archives;


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<PostArticle> getArchives() {
        return archives;
    }

    public void setArchives(List<PostArticle> archives) {
        this.archives = archives;
    }
}

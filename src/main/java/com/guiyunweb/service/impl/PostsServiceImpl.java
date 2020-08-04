package com.guiyunweb.service.impl;

import com.guiyunweb.model.dto.PageDTO;
import com.guiyunweb.model.entity.PostArticle;
import com.guiyunweb.model.vo.ArchiveVO;
import com.guiyunweb.model.vo.ShowArticleVO;
import com.guiyunweb.repository.PostArticleRepository;
import com.guiyunweb.service.PostsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsSerivce {

    @Autowired
    PostArticleRepository repository;

    @Override
    public void save(PostArticle article) {
        if (StringUtils.isEmpty(article.getId())) {
            article.setAccess(0);
            article.setComments(false);
            article.setCreateTime(new Date());
        }
        repository.save(article);
    }

    @Override
    public Page<PostArticle> getList(PostArticle article, PageDTO dto) {
        if (ObjectUtils.isArray(dto)) {
            dto = new PageDTO();
        }
        return repository.findAll(dto.getPageable());
    }

    @Override
    public PostArticle getInfo(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void del(PostArticle article) {
        repository.delete(article);
    }

    @Override
    public Page<ShowArticleVO> showList(PostArticle article, PageDTO dto) {
        if (ObjectUtils.isArray(dto)) {
            dto = new PageDTO();
        }
        return repository.findByIssued(true, dto.getPageable(Sort.Direction.DESC, "createTime"));
    }


    @Override
    public List<ArchiveVO> archive() {
        List<ArchiveVO> vos = new ArrayList<>();
        List<PostArticle> list = repository.findAll(Sort.by(Sort.Direction.DESC,"createTime"));
        ArchiveVO vo = new ArchiveVO();
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < list.size(); i++) {
            PostArticle article = list.get(i);
            cal.setTime(article.getCreateTime());
            Integer year = cal.get(Calendar.YEAR);
            if (i == 0) {
                vo.setYear(year);
                vo.setArchives(new ArrayList<>());
                vos.add(vo);
            }
            if (vo.getYear().equals(year)) {
                vo.getArchives().add(article);
            }else {
                vo = new ArchiveVO();
                vo.setArchives(new ArrayList<>());
                vo.setYear(year);
                vo.getArchives().add(article);
                vos.add(vo);
            }
        }
        return vos;
    }
}

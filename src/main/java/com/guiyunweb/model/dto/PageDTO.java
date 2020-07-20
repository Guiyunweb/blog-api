package com.guiyunweb.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;


@Getter
@Setter
public class PageDTO {

    private Integer page = 0;

    private Integer size = 10;

    public Pageable getPageable(){
        if (StringUtils.isEmpty(getPage())){
            setPage(0);
        }
        if (StringUtils.isEmpty(getSize())){
            setSize(10);
        }
        return PageRequest.of(getPage(),getSize());
    }

    public Pageable getPageable(Sort.Direction direction, String... properties){
        if (StringUtils.isEmpty(getPage())){
            setPage(0);
        }
        if (StringUtils.isEmpty(getSize())){
            setSize(10);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, properties);
        return PageRequest.of(getPage(),getSize(),sort);
    }
}

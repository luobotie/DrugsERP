package com.drug.luobo.mapper;

import java.util.List;

import com.drug.luobo.entity.News;
import com.drug.luobo.untils.NewsVo;


public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    
    /**
     * 查询
     */
    List<News> queryAllNews(NewsVo nVo); 
    Long getCount(NewsVo nVo);
}
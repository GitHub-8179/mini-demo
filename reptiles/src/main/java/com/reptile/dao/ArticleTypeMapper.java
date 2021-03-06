package com.reptile.dao;

import com.reptile.entity.ArticleType;
import com.reptile.entity.ArticleTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Integer articleTypeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(Integer articleTypeId);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}
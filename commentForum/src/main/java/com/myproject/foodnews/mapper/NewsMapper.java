package com.myproject.foodnews.mapper;

import com.myproject.foodnews.bean.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> queryAllNews();

    void insertLikeCount(int likeCount);

    int queryLikeCountByNewsId(int parseInt);

    void updateCommentCount(@Param("param1") int j, @Param("param2") Integer entityId);
}
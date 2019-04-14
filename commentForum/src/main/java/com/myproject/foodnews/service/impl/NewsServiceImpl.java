package com.myproject.foodnews.service.impl;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.mapper.NewsMapper;
import com.myproject.foodnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 16:55
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;


    @Override
    public List<News> queryAllNews() {
        return newsMapper.queryAllNews();
    }

    @Override
    public boolean insert(News news) {
        return newsMapper.insertSelective(news)==1;
    }

    @Override
    public News queryNewsById(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int queryLikeCountByNewsId(String newsId) {
        return newsMapper.queryLikeCountByNewsId(Integer.parseInt(newsId));
    }
}

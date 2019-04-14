package com.myproject.foodnews.service;

import com.myproject.foodnews.bean.News;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 16:55
 */
public interface NewsService {
    List<News> queryAllNews();

    boolean insert(News news);

    News queryNewsById(int id);

    int queryLikeCountByNewsId(String newsId);
}

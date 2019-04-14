package com.myproject.foodnews.service.impl;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.mapper.NewsMapper;
import com.myproject.foodnews.mapper.RedisDao;
import com.myproject.foodnews.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wawawa
 * Date 2019/4/12 Time 15:38
 */
@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    RedisDao redisDao;
    @Autowired
    NewsMapper newsMapper;

    @Override
    public boolean addLikeCount(String newsId, Integer UserId) {
       // int likeCount = jedis.scard(newsId).intValue();
        int i = redisDao.addLikeCount(newsId,UserId);
        if(i==1) {
            int likeCount = redisDao.queryLikeCountByNewsId(newsId);
            int dislikeCount = redisDao.queryDislikeByNewsId(newsId);
            News news = newsMapper.selectByPrimaryKey(Integer.parseInt(newsId));
            news.setLikeCount(likeCount-dislikeCount);
            int j= newsMapper.updateByPrimaryKeySelective(news);
        }
        return true;
    }

    @Override
    public boolean addDislikeCount(String newsId, String id) {
        int i = redisDao.addDislikeCount(newsId,id);
        if(i==1){
            int likeCount = redisDao.queryLikeCountByNewsId(newsId);
            int dislikeCount = redisDao.queryDislikeByNewsId(newsId);
            News news = newsMapper.selectByPrimaryKey(Integer.parseInt(newsId));
            news.setLikeCount(likeCount-dislikeCount);

            int j = newsMapper.updateByPrimaryKeySelective(news);
        }
        return true;
    }

    @Override
    public boolean isMemberofLike(String newsId,String id) {
        return redisDao.isLikeMember(newsId,id);
    }

    @Override
    public boolean isMemerofDislike(String newsId,String id) {
        return redisDao.isDislikeMember(newsId,id);
    }
}

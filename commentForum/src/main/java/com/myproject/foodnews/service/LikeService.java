package com.myproject.foodnews.service;

/**
 * Created by wawawa
 * Date 2019/4/12 Time 15:37
 */
public interface LikeService {
    boolean addLikeCount(String newsId, Integer id);

    boolean addDislikeCount(String newsId, String toString);

    boolean isMemberofLike(String newsId,String id);

    boolean isMemerofDislike(String newsId,String id);
}

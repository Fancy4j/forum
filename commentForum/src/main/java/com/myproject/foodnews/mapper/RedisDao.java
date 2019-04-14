package com.myproject.foodnews.mapper;

import com.myproject.foodnews.util.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

/**
 * Created by wawawa
 * Date 2019/4/12 Time 15:38
 */
@Repository
public class RedisDao {


    final static String prfix = "news_";
    final static String likeSuffix = "_like";
    final static String dislikeSuffix = "_dislike";


    public int addLikeCount(String newsId, Integer id) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        Boolean ismember = jedis.sismember(prfix + newsId + dislikeSuffix, id.toString());
        if(ismember){
            jedis.close();
            return 0;
        }
         int i = jedis.sadd(prfix+newsId+likeSuffix, id.toString()).intValue();
        if(jedis!=null) {
            jedis.close();
        }
        return i;
    }

    public int addDislikeCount(String newsId, String id) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        Boolean ismember = jedis.sismember(prfix + newsId + likeSuffix, id);
        if(ismember){
            jedis.close();
            return 0;
        }
        int i = jedis.sadd(prfix+newsId+dislikeSuffix,id).intValue();
        if(jedis!=null) {
            jedis.close();
        }
        return i;
    }

    public int queryLikeCountByNewsId(String newsId) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        int scard = jedis.scard(prfix + newsId + likeSuffix).intValue();
        if(jedis!=null) {
            jedis.close();
        }
        return scard;
    }

    public int queryDislikeByNewsId(String newsId) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        int scard = jedis.scard(prfix + newsId + dislikeSuffix).intValue();
        if(jedis!=null) {
            jedis.close();
        }
        return scard;
    }

    public boolean isLikeMember(String newsId,String id) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        Boolean ismember = jedis.sismember(prfix + newsId + likeSuffix,id);
        if(jedis!=null) {
            jedis.close();
        }
        return ismember;
    }

    public boolean isDislikeMember(String newsId,String id) {
        Jedis jedis = JedisUtils.getJedisFromPool();
        Boolean ismember = jedis.sismember(prfix + newsId + dislikeSuffix, id);

        if(jedis!=null) {
            jedis.close();
        }
        return ismember;
    }
}

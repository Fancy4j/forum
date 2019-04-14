package com.myproject.foodnews;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.service.NewsService;
import com.myproject.foodnews.util.JedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodnewsApplicationTests {

    @Autowired
    NewsService newsService;

    @Test
    public void contextLoads() {
        List<News> news = newsService.queryAllNews();
        Logger logger = LoggerFactory.getLogger(this.getClass());
        for (News news1 : news) {
            logger.error(" " + news1);
        }

    }

    @Test
    public void myRedis(){
        Jedis jedis = JedisUtils.getJedisFromPool();
        Long sadd = jedis.sadd("111", "12321");
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error("saad="+sadd);
        //System.out.println("sadd=" + sadd);
    }

}

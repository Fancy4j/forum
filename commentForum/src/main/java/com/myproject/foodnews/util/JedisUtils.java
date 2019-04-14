package com.myproject.foodnews.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by wawawa
 * Date 2019/4/12 Time 15:55
 */
public class JedisUtils {

    static JedisPool jedisPool = new JedisPool();


    public static Jedis getJedisFromPool(){
        Jedis resource = jedisPool.getResource();
        return resource;
    }

    public static String get(String key){
        String v = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            v = jedis.get(key);
        }catch(Exception e){
            System.out.println("e"+e.getCause());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }

        return v;
    }

    public static String set(String key,String value){
        Jedis jedis = null;
        String set= null;
        try{
            jedis= jedisPool.getResource();
            set = jedis.set(key, value);
        }catch(Exception e){
            System.out.println("e"+e.getCause());
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return set;
    }
}

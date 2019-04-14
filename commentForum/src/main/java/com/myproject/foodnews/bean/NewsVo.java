package com.myproject.foodnews.bean;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 16:31
 */
public class NewsVo {
    User user;
    private int like;
    private News news;




    public int getLike() {
        return like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "NewsVo{" +
                "user=" + user +
                ", like=" + like +
                ", news=" + news +
                '}';
    }
}



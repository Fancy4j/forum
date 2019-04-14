package com.myproject.foodnews.controller;

import com.myproject.foodnews.bean.MsgVo;
import com.myproject.foodnews.bean.User;
import com.myproject.foodnews.mapper.RedisDao;
import com.myproject.foodnews.service.LikeService;
import com.myproject.foodnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wawawa
 * Date 2019/4/12 Time 15:37
 */
@Controller
public class LikeController {

    @Autowired
    LikeService likeService;

    @Autowired
    NewsService newsService;

    @Autowired
    RedisDao redisDao;

    @RequestMapping("like")
    @ResponseBody
    public MsgVo like(String newsId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null) {
            boolean b = likeService.addLikeCount(newsId, user.getId());
        }
        int likeCount = newsService.queryLikeCountByNewsId(newsId);

        return new MsgVo(0,String.valueOf(likeCount));
    }


    @RequestMapping("dislike")
    @ResponseBody
    public MsgVo dislike(String newsId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null) {
            boolean b = likeService.addDislikeCount(newsId, user.getId().toString());
        }
        int likeCount = newsService.queryLikeCountByNewsId(newsId);

        return new MsgVo(0,String.valueOf(likeCount));
    }
}

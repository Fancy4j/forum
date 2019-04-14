package com.myproject.foodnews.controller;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.bean.NewsVo;

import com.myproject.foodnews.bean.User;
import com.myproject.foodnews.mapper.NewsMapper;
import com.myproject.foodnews.service.LikeService;
import com.myproject.foodnews.service.NewsService;
import com.myproject.foodnews.service.UserzService;
import com.myproject.foodnews.service.impl.NewsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 15:14
 */
@Controller
public class MainController {

    @Autowired
    UserzService userService;

    @Autowired
    NewsService newsService;

    @Autowired
    LikeService likeService;

    @RequestMapping("home")
    public String toHomePage(Model model, HttpServletRequest request){

        List<News> newsList = newsService.queryAllNews();
        User user1 = userService.queryUser();
        int like = 0;
        ArrayList<NewsVo> list = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");

        if(newsList!=null) {
            for (News news : newsList) {
                 NewsVo newsVo = new NewsVo();
                 newsVo.setUser(user1);
                 if(user==null) {
                     newsVo.setLike(0);
                 }else {
                     if(likeService.isMemberofLike(news.getId().toString(),user.getId().toString())){
                         like = 1;
                     }
                     if(likeService.isMemerofDislike(news.getId().toString(),user.getId().toString())){
                         like = -1;
                     }
                     newsVo.setLike(like);
                 }

                 newsVo.setNews(news);
                 list.add(newsVo);

             }
        }
        model.addAttribute("vos",list);
       return "home";
    }


}

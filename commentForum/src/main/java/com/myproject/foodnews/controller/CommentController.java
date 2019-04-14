package com.myproject.foodnews.controller;

import com.myproject.foodnews.bean.*;
import com.myproject.foodnews.service.CommentService;
import com.myproject.foodnews.service.NewsService;
import com.myproject.foodnews.service.UserzService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wawawa
 * Date 2019/4/11 Time 17:48
 */
@Controller
public class CommentController {
    @Autowired
    NewsService newsService;

    @Autowired
    UserzService userzService;

    @Autowired
    CommentService commentService;

    @RequestMapping("news/{id}")
    public String toComment(@PathVariable(value = "id") int id, Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<Comment> comments = commentService.queryCommentByEntityId(id);
        News news = newsService.queryNewsById(id);
        ArrayList<CommentVo> list = new ArrayList<>();
        User user1 = userzService.queryUser();
        if(comments!=null) {
            for (Comment comment : comments) {
                CommentVo commentVo = new CommentVo();
                commentVo.setUser(user1);
                commentVo.setComment(comment);
                list.add(commentVo);
            }
        }
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error("comment=" + list);
        model.addAttribute("comments",list);
        model.addAttribute("news",news);
        model.addAttribute("owner",user);
        model.addAttribute("like",0);
      //  model.addAttribute("comment", comments);

        return "detail";
    }

    @RequestMapping("addComment")
    public String addComment(@RequestParam String content,@RequestParam int newsId, HttpServletRequest request){
        Comment comment = new Comment();
        User user = (User) request.getSession().getAttribute("user");
        comment.setUserId(user.getId());
        comment.setEntityId(newsId);
        comment.setContent(content);

        boolean b = commentService.insertBySelective(comment);

        return "redirect:/news/"+newsId ;
    }
}

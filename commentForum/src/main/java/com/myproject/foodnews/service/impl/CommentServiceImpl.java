package com.myproject.foodnews.service.impl;

import com.myproject.foodnews.bean.Comment;
import com.myproject.foodnews.mapper.CommentMapper;
import com.myproject.foodnews.mapper.NewsMapper;
import com.myproject.foodnews.service.CommentService;
import com.myproject.foodnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by wawawa
 * Date 2019/4/11 Time 20:38
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    NewsMapper newsMapper;


    @Override
    public ArrayList<Comment> queryCommentByEntityId(int id) {
        return commentMapper.queryCommentByEntityId(id);
    }

    @Override
    public boolean insertBySelective(Comment comment) {
        int i = commentMapper.insertSelective(comment);
        int j = commentMapper.queryCommentCountByEntityEntityId(comment.getEntityId());
        newsMapper.updateCommentCount(j,comment.getEntityId());
        return i==1;
    }
}

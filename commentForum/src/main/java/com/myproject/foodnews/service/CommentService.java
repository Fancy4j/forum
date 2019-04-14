package com.myproject.foodnews.service;

import com.myproject.foodnews.bean.Comment;

import java.util.ArrayList;

/**
 * Created by wawawa
 * Date 2019/4/11 Time 20:38
 */
public interface CommentService {
    ArrayList<Comment> queryCommentByEntityId(int id);

    boolean insertBySelective(Comment comment);
}

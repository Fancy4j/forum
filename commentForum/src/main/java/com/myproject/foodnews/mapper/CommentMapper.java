package com.myproject.foodnews.mapper;

import com.myproject.foodnews.bean.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    ArrayList<Comment> queryCommentByEntityId(@Param("id") int id);

    int queryCommentCountByEntityEntityId(@Param("entityId") Integer entityId);
}
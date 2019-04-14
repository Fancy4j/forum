package com.myproject.foodnews.mapper;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.bean.User;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<News> queryAllUser();

    Integer isUserExist(@Param("username") String username,@Param("password") String password);

    User getIdAndHeadUrlByUsernameAndPassword(String username, String password);

    Integer isUserExist2(@Param("username") String username);
}
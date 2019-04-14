package com.myproject.foodnews.service.impl;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.bean.User;
import com.myproject.foodnews.mapper.UserMapper;
import com.myproject.foodnews.service.UserzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 15:39
 */
@Service
public class UserServiceImpl implements UserzService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public boolean isUserExist(String username, String password) {
        Integer i = userMapper.isUserExist(username, password);
        if(i!=null){
            return true;
        }
        return false;
    }

    @Override
    public User getIdAndHeadUrlByUsernameAndPassword(String username, String password) {
        return userMapper.getIdAndHeadUrlByUsernameAndPassword(username,password);
    }

    @Override
    public boolean insert(User user) {
        return userMapper.insertSelective(user)==1;
    }

    @Override
    public boolean isUserExist2(String username) {
        Integer i = userMapper.isUserExist2(username);
        if(i!=null){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public User queryUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

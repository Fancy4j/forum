package com.myproject.foodnews.service;

import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.bean.User;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 15:39
 */
public interface UserzService {
    User queryUser();

    boolean isUserExist(String username, String password);

    User getIdAndHeadUrlByUsernameAndPassword(String username, String password);

    boolean insert(User user);

    boolean isUserExist2(String username);

    User queryUserById(int id);
}

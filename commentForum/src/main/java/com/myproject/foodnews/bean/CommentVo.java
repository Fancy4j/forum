package com.myproject.foodnews.bean;

/**
 * Created by wawawa
 * Date 2019/4/11 Time 21:27
 */
public class CommentVo {
    private  User user;
    private Comment comment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}

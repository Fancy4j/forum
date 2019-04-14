package com.myproject.foodnews.bean;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 19:13
 */
public class MsgVo {
    private int code;
    private String msg;
    private String msgpwd;
    private String msgname;

    public MsgVo() {
    }

    public MsgVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MsgVo(int code, String msg, String msgpwd, String msgname) {
        this.code = code;
        this.msg = msg;
        this.msgpwd = msgpwd;
        this.msgname = msgname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgname() {
        return msgname;
    }

    public void setMsgname(String msgname) {
        this.msgname = msgname;
    }

    public String getMsgpwd() {
        return msgpwd;
    }

    public void setMsgpwd(String msgpwd) {
        this.msgpwd = msgpwd;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

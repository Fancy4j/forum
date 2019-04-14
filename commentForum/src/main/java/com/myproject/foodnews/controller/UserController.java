package com.myproject.foodnews.controller;

import com.myproject.foodnews.bean.MsgVo;
import com.myproject.foodnews.bean.News;
import com.myproject.foodnews.bean.User;
import com.myproject.foodnews.service.NewsService;
import com.myproject.foodnews.service.UserzService;
import com.myproject.foodnews.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wawawa
 * Date 2019/4/10 Time 19:11
 */
@Controller
public class UserController {

    @Autowired
    UserzService userzService;

    @Autowired
    NewsService newsService;

    @RequestMapping("login")
    @ResponseBody
    public MsgVo login( @RequestParam String username,@RequestParam  String password, HttpServletRequest request){
        boolean flag = userzService.isUserExist(username,password);
        User user = userzService.getIdAndHeadUrlByUsernameAndPassword(username,password);

        HttpSession session = request.getSession();
        if(!flag){
            MsgVo msgVo = new MsgVo();
            msgVo.setCode(1);
            msgVo.setMsgpwd("密码不正确");
            msgVo.setMsgname("用户名或密码错误");
            return msgVo;
        }
        MsgVo msgVo = new MsgVo();
        msgVo.setCode(0);
        session.setAttribute("user",user);
        return msgVo;
    }

    @RequestMapping("reg")
    @ResponseBody
    public MsgVo register(User user, HttpServletRequest request){
        MsgVo msgVo = new MsgVo();
        boolean b = userzService.isUserExist2(user.getUsername());
        if(b){
            msgVo.setCode(1);
            msgVo.setMsgname("用户名已经被注册");
            return msgVo;
        }
        boolean flag = userzService.insert(user);
        User user1 = userzService.getIdAndHeadUrlByUsernameAndPassword(user.getUsername(), user.getPassword());
        user.setId(user1.getId());
        if(!flag){
            msgVo.setCode(1);
            msgVo.setMsgpwd("密码格式不正确");
            return msgVo;
        }
        HttpSession session = request.getSession();
        msgVo.setCode(0);
        session.setAttribute("user",user);
        return msgVo;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        String username="";
        String password = "";
        if(user!=null){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
        }
        return "redirect:/home";
    }

    @RequestMapping("/user/addNews")
    @ResponseBody
    public MsgVo addNews( News news,HttpServletRequest request){
        MsgVo msgVo = new MsgVo();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null) {
            news.setUserzId(user.getId());
        }
        news.setCommentCount(0);
        news.setLikeCount(0);
        boolean b = newsService.insert(news);
        if(b){
            msgVo.setCode(0);
            return msgVo;
        }
        msgVo.setCode(1);
        return msgVo;
    }

    @RequestMapping("user/{id}")
    public String profile(@PathVariable(value = "id") int id){

        return "personal";
    }

    @RequestMapping("user/tosendmsg")
    public String toSendMsg(){
        return "sendmsg";
    }


}

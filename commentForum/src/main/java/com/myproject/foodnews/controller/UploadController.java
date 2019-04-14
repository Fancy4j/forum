package com.myproject.foodnews.controller;

import com.myproject.foodnews.bean.MsgVo;
import com.myproject.foodnews.service.impl.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wawawa
 * Date 2019/4/11 Time 10:52
 */
@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @RequestMapping("uploadImage")
    @ResponseBody
    public MsgVo uploadImage(MultipartFile file, Model model) throws IOException {
        MsgVo msgVo = new MsgVo();
        // String originalFilename = file.getOriginalFilename();
        String s = uploadService.updload(file);
        msgVo.setMsg(s+"?x-oss-process=image/resize,m_fill,h_100,w_80");
        msgVo.setCode(0);
        return msgVo;
    }



}

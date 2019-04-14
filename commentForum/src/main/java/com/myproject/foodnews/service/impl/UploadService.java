package com.myproject.foodnews.service.impl;

import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by wawawa
 * Date 2019/4/11 Time 14:41
 */
@Service
public class UploadService {

    String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

    String accessKeyId = "LTAIvOfFBk2mW0rT";

    String accessKeySecret = "Es1WmpiGJQOhurfPsKnHPbQwR3MfST";

    String buketname = "wangdao12";

    public String updload(MultipartFile file) throws IOException {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        String originalFilename = file.getOriginalFilename();

        InputStream inputStream = file.getInputStream();

        String key = UUID.randomUUID().toString().replaceAll("-","")+file.getOriginalFilename();

        ossClient.putObject(buketname,key,inputStream);

        ossClient.shutdown();
        return "https://" + buketname + ".oss-cn-hangzhou.aliyuncs.com" + "/" + key;
    }
}

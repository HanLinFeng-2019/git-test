package com.pinyougou.manager.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")//将配置文件的FILE_SERVER_URL信息注入给定义的字符串
    private String file_server_url;

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename();//获取文件全名称
        String exName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);//得到扩展名


        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String fileID = fastDFSClient.uploadFile(file.getBytes(), exName);

            String url=file_server_url+fileID;//完整的图片地址

            return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"上传失败");
        }
    }
}

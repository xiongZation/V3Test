package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Controller
public class imgController implements ServletContextAware {

    @Autowired
    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }

    @RequestMapping("imageupload")
    @ResponseBody
    public String imageupload(@RequestParam("fileImage") CommonsMultipartFile fileImage){

        //获取上传图片的位置
        String path = servletContext.getRealPath("/resource/upload/");
        //获取文件名称
        String filename = fileImage.getOriginalFilename();
        //创建file对象 写入
        File file = new File(path,filename);
        try {
            fileImage.getFileItem().write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将路径以json格式返回客户端
        String imagePath = "/resource/upload/"+filename;
        System.out.println(imagePath);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imagePath",imagePath);
        String json = jsonObject.toJSONString();
        return json;
    }
}

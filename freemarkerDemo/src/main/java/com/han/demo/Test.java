package com.han.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException, TemplateException {
        //1.创建一个配置类的对象
        Configuration configuration=new Configuration(Configuration.getVersion());
        //2.加载模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("D:\\IdeaProjects\\freemarkerDemo\\src\\main\\resources"));
        //3.设置字符集
        configuration.setDefaultEncoding("UTF-8");
        //4.获取模板对象
        Template template = configuration.getTemplate("test.ftl");
        //5.创建数据模型(可以是对象,也可以是Map)
        Map map=new HashMap();
        map.put("name","张三");
        map.put("message","欢迎光临!");
        //6.创建文件输出流对象
        Writer out=new FileWriter("e:\\test.html");
        //7.输出
        template.process(map,out);
        //8.关闭流
        out.close();
    }
}

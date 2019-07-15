package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHellow(String username){
        System.out.println("Hellow SpringMVC");
        System.out.println(username);
        return "success";
    }
    @RequestMapping(value="/requestMapping",method={RequestMethod.POST},params={})
    public String dispatchServlet(){
        System.out.println("测试requestMapping注解");
        return "success";
    }
}

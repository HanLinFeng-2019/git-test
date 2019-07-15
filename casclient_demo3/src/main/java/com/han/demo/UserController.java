package com.han.demo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("findLoginUser")
    public void findLoginUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("当前登陆名:"+name);
    }
}

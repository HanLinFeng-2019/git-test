package com.pinyougou.user.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping("/showLoginName")
    public String showLoginName(){
        String loginName= SecurityContextHolder.getContext().getAuthentication().getName();
        return loginName;
    }
}

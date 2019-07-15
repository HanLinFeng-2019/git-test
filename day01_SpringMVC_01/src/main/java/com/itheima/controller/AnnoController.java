package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/anno")
public class AnnoController {
    @RequestMapping("/param")
    public String testRequestParam(@RequestParam(name="name") String name){

        System.out.println(name);
        return "success";
    }
    @RequestMapping("/body")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }


    @RequestMapping("/path/{sid}")
    public String testPathVariable(@PathVariable(name="sid")String id){

        System.out.println(id);
        return "success";
    }
}

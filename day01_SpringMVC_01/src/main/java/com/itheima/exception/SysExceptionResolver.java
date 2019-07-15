package com.itheima.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        sysException e=null;
        if(ex instanceof sysException){
            e=(sysException)ex;
        }else{
            e=new sysException("服务器正忙");
        }

        ModelAndView mv = new ModelAndView();

        mv.addObject("message",e.getMassage());
        mv.setViewName("error");
        return null;
    }
}

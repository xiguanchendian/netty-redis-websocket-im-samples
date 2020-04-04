package com.hitencent.samples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ws")
public class WSController {

    @RequestMapping("/view")
    public ModelAndView goToWSView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/websocket");
        return mav;
    }

}

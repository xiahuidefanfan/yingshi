package com.hx.hkTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//web页面
@Controller
@RequestMapping("/s")
public class IndexController {
	@RequestMapping("/hello")
    public String helloHtml() {
        return "/demo";
    }
	
	@RequestMapping("/approval")
    public String approval() {
        return "/approval";
    }
	
	
}

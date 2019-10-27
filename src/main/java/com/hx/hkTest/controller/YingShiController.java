package com.hx.hkTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yingshi")
public class YingShiController {

	@RequestMapping("/hls")
    public String hls() {
        return "hls";
    }
	
	@RequestMapping("/rtmp")
    public String rtmp() {
        return "rtmp";
    }
    
    @RequestMapping("/demoMonitor")
    public String demoMonitor() {
        return "demo-monitor";
    }
}

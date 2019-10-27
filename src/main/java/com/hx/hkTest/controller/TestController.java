package com.hx.hkTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hx.hkTest.utils.ClientDemo;

//摄像头注册的类
@RestController
@RequestMapping("/a")
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public int test(String username,String password,String m_sDeviceIP) {
		System.out.println(username);
		ClientDemo cd= new ClientDemo();
		//初始化
		cd.CameraInit();
		//注册
		cd.register(username,password,m_sDeviceIP);
		cd.SetupAlarmChan();
		return 1; 
	}
}
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;

import com.model.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value ="/hello.sp")
	public String test01(Model model) {
		model.addAttribute("myMessage", helloService.getHello());
		return "/WEB-INF/view01/hello.jsp";
	}
}

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value ="/test01.sp")
	public String test01() {
		return "/WEB-INF/view/test01.jsp";
	}
	
	@RequestMapping(value ="/test02.sp")
	public String test02() {
		return "/WEB-INF/view/test02.jsp";
	}
	
	@RequestMapping(value ="/test03.sp")
	public String test03() {
		return "/WEB-INF/view/test03.jsp";
	}
	
	@RequestMapping(value ="/test04.sp")
	public String test04() {
		return "/WEB-INF/view01/test04.jsp";
	}
	
	@RequestMapping(value ="/test05.sp")
	public String test05() {
		return "/WEB-INF/view01/test05.jsp";
	}
}

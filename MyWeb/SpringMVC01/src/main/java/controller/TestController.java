package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value ="/test.sp")
	public String test() {
		return "/WEB-INF/view/test.jsp";
	}
		
}

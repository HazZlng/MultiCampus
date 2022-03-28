package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.domain.MemberVO;
import com.service.SignUpService;

@Controller
public class SignUpController {

	@Autowired
	SignUpService service;
	
	@RequestMapping(value ="/signUpPage.do")
	public String signUpPage(){
		
		return "signUp";
	}
	
	@RequestMapping(value = "/signUp.do")
	public String signUp(MemberVO vo) {
		
		service.signUp(vo);
		
		return "login";
	}
	
	//produces는 ajax가 데이터 넘겨받을때 깨짐 방지
	@RequestMapping(value = "/idCheck.do",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		int result=service.idCheck(userId);
		return Integer.toString(result);
	}
}

package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.domain.MemberVO;
import com.service.MemberService;


@Controller
@SessionAttributes("login")
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	
	//�α��� ó��
	@RequestMapping(value="/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo,HttpSession session) {
		
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		if(result) {
			mav.addObject("msg","����");
		}else {
			mav.addObject("msg","����");
		}
		
		return mav;
	}
	
	//�α׾ƿ� ó��
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		
		return mav;
	}
	
}
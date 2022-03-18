package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.model.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//입력 페이지로 이동
	@RequestMapping("/insert.sp")
	public ModelAndView insertPage() {
		return new ModelAndView("insert");
	}
	
	//입력하기 : 입력페이지에서 값을받아 엔티티로 전달한 객체를 서비스로 DAO를 통해 저장한다.
	@RequestMapping(value = "/insert_res.sp", method = RequestMethod.POST)
	public ModelAndView insertRes(@ModelAttribute User user) {
//		if(userService.insertUser(user) == true) {
//			return "/list.sp";
//		} else {
			return new ModelAndView("insert");
//		}
	}
	
	//전체출력
	@RequestMapping("/list.sp")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView( "list", "allList", userService.listUser());
		return model;
	}
}

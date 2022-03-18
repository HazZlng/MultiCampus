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
	
	//�Է� �������� �̵�
	@RequestMapping("/insert.sp")
	public ModelAndView insertPage() {
		return new ModelAndView("insert");
	}
	
	//�Է��ϱ� : �Է����������� �����޾� ��ƼƼ�� ������ ��ü�� ���񽺷� DAO�� ���� �����Ѵ�.
	@RequestMapping(value = "/insert_res.sp", method = RequestMethod.POST)
	public ModelAndView insertRes(@ModelAttribute User user) {
//		if(userService.insertUser(user) == true) {
//			return "/list.sp";
//		} else {
			return new ModelAndView("insert");
//		}
	}
	
	//��ü���
	@RequestMapping("/list.sp")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView( "list", "allList", userService.listUser());
		return model;
	}
}

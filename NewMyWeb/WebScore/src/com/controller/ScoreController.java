package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biz.ScoreBIZ;
import com.entity.ScoreEntity;
import com.vo.ScoreVO;

//requestScope
//  { "/MyServlet", "/select", "/insert", "/delete", "/update", "/find" })
@Controller
@RequestMapping("/score/*")
public class ScoreController {
    @Autowired
    ScoreBIZ scoreBiz;

    @GetMapping("/list.do")
    public ModelAndView mySelect() {
    	List<ScoreEntity> all = scoreBiz.getAllScore();
    	return new ModelAndView("listScore", "all", all);
    }
    
    @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
    public String myDelete(@RequestParam("del_name") String name) {
    	int result = scoreBiz.getDelScore(name);
    	if(result > 0) {
    		return "redirect:/score/list.do";
    	}
    	else
    		return " ";
    }
    
    @RequestMapping(value = "/find.do", method = RequestMethod.GET)
    public ModelAndView myFind(@RequestParam("find_name") String name) {
    	ScoreEntity result = scoreBiz.getFindScore(name);
    	return new ModelAndView("updateScore", "find", result);
    }
    
    @RequestMapping(value = "/update.do", method = RequestMethod.GET)
    public String myUpdate(@ModelAttribute("scoreVo") ScoreVO vo) {
    	int result = scoreBiz.getUpdateScore(vo);
    	return "redirect:/score/list.do";
    }
    
    ///score/input.do
    @GetMapping("input.do")
    public ModelAndView myInput(ModelAndView view) {
    	view.setViewName("inputScore"); 			// WEB-INF/socre/inputScore.jsp
    	return view;
    }
    
    @PostMapping("/insert.do")
    public ModelAndView register(@ModelAttribute("scoreVo") ScoreVO vo) {
    	int result = scoreBiz.getInsertScore(vo);
    	if(result > 0)
    		return new ModelAndView("listScore", "all", scoreBiz.getAllScore());
    	else 
    		return new ModelAndView("error"); 
    }
}





















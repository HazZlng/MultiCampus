package com.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.*;
import com.entity.*;

//@WebServlet("/ScoreAll")
public class ScoreAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Score> all = new ScoreBiz().getScoreAll();
		
		request.setAttribute("all", all);
		
		RequestDispatcher rd = request.getRequestDispatcher("ScoreAll.jsp");
		rd.forward(request,response);
	}
}
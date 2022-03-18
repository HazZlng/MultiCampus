package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ScoreBiz;

//@WebServlet("/ScoreDelete")
public class ScoreDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int r = new ScoreBiz().getScoreDelete(request.getParameter("name"));
		if(r > 0)
			response.sendRedirect("ScoreAll");
	}

}

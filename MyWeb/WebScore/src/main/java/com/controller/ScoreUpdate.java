package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ScoreBiz;
import com.entity.Score;

//@WebServlet("/ScoreUpdate")
public class ScoreUpdate extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		Score myScore = new Score(name, kor, eng, mat);
		
		int r = new ScoreBiz().getScoreUpdate(myScore);
		if(r>0)
			response.sendRedirect("ScoreAll");
	}
}

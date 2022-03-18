package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ScoreBiz;
import com.entity.Score;

@WebServlet({ "/MyController", "/ScoreAll", "/ScoreDelete",
"/ScoreUpdate", "/ScoreFind", "/ScoreInput" })
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String _url = request.getRequestURI();
		
		if (_url.endsWith("ScoreAll")) {
			doScoreAll(request, response);
		} else if (_url.endsWith("ScoreUpdate")) {
			doScoreUpdate(request, response);
		} else if (_url.endsWith("ScoreDelete")) {
			doScoreDelete(request, response);
		} else if (_url.endsWith("ScoreFind")) {
			doScoreFind(request, response);
		} else if (_url.endsWith("ScoreInput")) {
			doScoreInput(request, response);
		}


	}

	protected void doScoreAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Score> all = new ScoreBiz().getScoreAll();
		
		request.setAttribute("all", all);
		
		RequestDispatcher rd = request.getRequestDispatcher("ScoreAll.jsp");
		rd.forward(request,response);
	}
	
	protected void doScoreDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int r = new ScoreBiz().getScoreDelete(request.getParameter("name"));
		if(r > 0)
			response.sendRedirect("ScoreAll");
	}
	
	protected void doScoreFind(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Score myScore = new ScoreBiz().getScoreFind(name);
		
		request.setAttribute("find", myScore);
		RequestDispatcher rd = request.getRequestDispatcher("ScoreUpdate.jsp");
		rd.forward(request, response);
	}
	
	protected void doScoreInput(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Score myScore = new Score();
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		myScore.setName(name);
		myScore.setKor(kor);
		myScore.setEng(eng);
		myScore.setMat(mat);
		
		ScoreBiz biz = new ScoreBiz();
		int r = biz.getScoreInsert(myScore);
		if(r>0)
		{
			response.sendRedirect("ScoreAll");
		}
	}

	protected void doScoreUpdate(HttpServletRequest request, HttpServletResponse response) 
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

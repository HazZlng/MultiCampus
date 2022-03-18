package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Score;
import com.biz.*;

//@WebServlet("/ScoreInput")
public class ScoreInput extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Score myScore = new Score();
		String name = req.getParameter("name");
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int mat = Integer.parseInt(req.getParameter("mat"));
		myScore.setName(name);
		myScore.setKor(kor);
		myScore.setEng(eng);
		myScore.setMat(mat);
		
		ScoreBiz biz = new ScoreBiz();
		int r = biz.getScoreInsert(myScore);
		if(r>0)
		{
			resp.sendRedirect("ScoreAll");
		}
	}

}

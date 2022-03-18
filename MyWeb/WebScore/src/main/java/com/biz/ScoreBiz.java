package com.biz;

import java.sql.*;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.dao.ScoreDao;
import com.entity.Score;
import static com.common.JdbcTemplate.*;

@WebServlet("/ScoreBiz")
public class ScoreBiz {
	// view -> controller -> biz -> dao
	
	public List<Score> getScoreAll() {
		Connection conn = getConnection();
		List<Score> result = new ScoreDao(conn).getScoreAll();
		
		close(conn);
		
		return result;
	}

	public int getScoreInsert(Score myScore) {
		Connection conn = getConnection();
		int result = new ScoreDao(conn).getScoreInsert(myScore);

		close(conn);		
		return result;
	} 
	
	public int getScoreUpdate(Score myScore) {
		Connection conn = getConnection();
		int result = new ScoreDao(conn).getScoreUpdate(myScore);

		close(conn);		
		return result;
	}
	
	public int getScoreDelete(String name) {
		Connection conn = getConnection();
		int result = new ScoreDao(conn).getScoreDelete(name);

		close(conn);		
		return result;
	}
	
	public Score getScoreFind(String name) {
		Connection conn = getConnection();
		Score result = new ScoreDao(conn).getScoreFind(name);

		close(conn);		
		return result;
	}
}

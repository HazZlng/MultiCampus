package com.dao;

import com.entity.*;
import java.util.*;
import java.sql.*;

import static com.common.JdbcTemplate.*;


public class ScoreDao implements ScoreSql{

	Connection conn;
	
	public ScoreDao(Connection con) 
	{
		this.conn = con;
	}
	
	public List<Score> getScoreAll()
	{
//		String sql = "select * from Score";
		Score myScore = null;
		List<Score> result = new ArrayList<Score>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//select 결과를 rs 로 리턴
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectAll);
			
			while(rs.next())
			{
				myScore = new Score(rs.getString(1), rs.getInt(2),
						rs.getInt(3), rs.getInt(4));
//				myScore.setName(rs.getString(1));
//				myScore.setKor(rs.getInt(2));
//				myScore.setEng(rs.getInt(3));
//				myScore.setMat(rs.getInt(4));
				
				result.add(myScore);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return result;
	}
	
	public Score getScoreFind(String name)
	{
//		String sql = "select * from Score";
		Score myScore = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//select 결과를 rs 로 리턴
			stmt = conn.prepareStatement(findScore);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				myScore = new Score(rs.getString(1), rs.getInt(2),
						rs.getInt(3), rs.getInt(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return myScore;
	}
	
	public int getScoreInsert(Score myScore) {
		PreparedStatement pstm = null;
		int result = 0;
		
		try {
			pstm = conn.prepareStatement(insertScore);
			pstm.setString(1, myScore.getName());
			pstm.setInt(2, myScore.getKor());
			pstm.setInt(3, myScore.getEng());
			pstm.setInt(4, myScore.getMat());
			pstm.setInt(5, myScore.getTot());
			pstm.setDouble(6, myScore.getAvg());
			pstm.setString(7, myScore.getGrade());
			
			result = pstm.executeUpdate();
			
			if(result > 0){
				commit(conn);
			}
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(pstm);
		}
		return result;
	}

	public int getScoreUpdate(Score myScore) {
		PreparedStatement pstm = null;
		int result = 0;
		
		try {
			pstm = conn.prepareStatement(updateScore);
			
			pstm.setInt(1, myScore.getKor());
			pstm.setInt(2, myScore.getEng());
			pstm.setInt(3, myScore.getMat());
			pstm.setString(4, myScore.getName());
			
			result = pstm.executeUpdate();
			
			if(result > 0){
				commit(conn);
			}
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(pstm);
		}
		return result;
	}
	
	public int getScoreDelete(String name) {
		PreparedStatement pstm = null;
		int result = 0;
		
		try {
			pstm = conn.prepareStatement(deleteScore);
			pstm.setString(1, name);
			
			result = pstm.executeUpdate();
			
			if(result > 0){
				commit(conn);
			}
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(pstm);
		}
		return result;
	}


}

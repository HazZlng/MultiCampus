package com.common;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcTemplate {
	/*
	 * 연결
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();								//웹프로젝트 초기화
			Context envContext = (Context)initContext.lookup("java:/comp/env");		//환경설정 디렉토리 설정
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");				//데이터베이스 연결 별칭
													
			conn = ds.getConnection();												//결과 저장
			conn.setAutoCommit(false);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/*
	 * 연결확인
	 */
	public static boolean isConnection(Connection conn) {
		boolean valid = true;
		
		try {
			if(conn == null || conn.isClosed()) {
				valid = false;
			}
			
		} catch (SQLException se) {
			// TODO: handle exception
			valid = true;
			se.printStackTrace();
		}
		return valid;
	}
	
	/*
	 * _ResultSet close
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * _Statement close
	 */
	public static void close(Statement st) {
		try {
			if(st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * _Connection close
	 */
	public static void close(Connection conn) {
		try {
			if(isConnection(conn))
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * commit
	 */
	public static void commit(Connection conn) {
		if(isConnection(conn))	{
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * rollback
	 */
	public static void rollback(Connection conn) {
		if(isConnection(conn))
		{
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

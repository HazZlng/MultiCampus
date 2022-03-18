package mc.ys.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseMain dm = new DatabaseMain();
		dm.testQuery();
	}
	
	public void testConnection() {
		//Mysql에 접속하여 컨넥션 객체가 만들어져서 전달되는지 확인하는 코드
		// 컨넥션 객체는 ConnectionManager 클래스의 getConnection메소드를 호출하여 전달받는다.
		// ConnectionManager 클래스의 패키는 실행클래스와 동일하다.
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		if(con!=null) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
	
	public void testQuery() {
		String sql = "select * from usertbl";
		//컨넥션 요청
		Connection con = new ConnectionManager().getConnection();
		//쿼리와 결과가 통과하는 통로 만들기
		Statement stmt;
		try {
			stmt = con.createStatement();
			//쿼리를 DB로 보내기 //쿼리 결과 받기
			ResultSet rs = stmt.executeQuery(sql);
			//결과 처리하기
			while(rs.next()) {
				System.out.printf("%s %s %s %n", rs.getString(1),rs.getString(2),rs.getString(3));
			}
			//연결종료하기
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

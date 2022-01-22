package dbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {
	
	
	
	//서버접속에 필요한 정보
	String _url = "jdbc:mysql://localhost:3306/sqldb";
	//String _driver = "com.mysql.jdbc.Driver";
	String _id = "root";
	String _pwd = "wlsghks!1";
	
	BookDAO(String _driver)
	{
		try {
			Class.forName(_driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Book테이블에 데이터 저장
	public void insertBook(BookDTO dto)
	{
		Connection con = null;
		Statement stmt = null;

		String _query = "insert into Book values('"+ dto.getBookNo() + "','" + dto.getBookTitle() + "','" + dto.getBookAuthor() + "',"
				+ dto.getBookYear() + "," + dto.getBookPrice() + ",'" + dto.getBookPublisher() +"');";
		
		try {
			con = DriverManager.getConnection(_url, _id, _pwd);
			stmt = con.createStatement();
			stmt.executeUpdate(_query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Book 테이블에 있는 모든 데이터 출력
	public void selectBook()
	{
		int index = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String _query = "select * from Book;";
		
		try {
			con = DriverManager.getConnection(_url, _id, _pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery(_query);	
			
			while(rs.next())
			{
				String bookNo			= rs.getString(1);
				String bookTitle		= rs.getString(2);
				String bookAuthor		= rs.getString(3);
				int bookYear			= rs.getInt(4);
				int bookPrice			= rs.getInt(5);
				String bookPublisher	= rs.getString(6);
				
				System.out.printf("%s %s %s %d %d %s \n", bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

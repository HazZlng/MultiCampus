package dbProject_Refactored;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public ArrayList<BookDTO> selectBook()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookDTO> result = new ArrayList<BookDTO>();
		String _query = "select * from Book;";
		
		try {
			con = DriverManager.getConnection(_url, _id, _pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery(_query);	
			
			while(rs.next())
			{
				String bookNo			= rs.getString("bookNo");
				String bookTitle		= rs.getString("bookTitle");
				String bookAuthor		= rs.getString("bookAuthor");
				int bookYear			= rs.getInt("bookYear");
				int bookPrice			= rs.getInt("bookPrice");
				String bookPublisher	= rs.getString("bookPublisher");
				
				BookDTO dto = new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
				result.add(dto);
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
		
		return result;
	}
}

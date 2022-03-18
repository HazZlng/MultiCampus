package sample10;

import java.sql.*;
import javax.sql.*;

public class MemberDAO {
	private DataSource dataSource;

	
	public MemberDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void ConnectionRes() throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		System.out.println("연결성공");
		conn.close();
	}
	
	public int getInsert(MemberDTO dto) throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		String _sql = "insert into springtest values(?, ?, ?)";
		PreparedStatement pstm = conn.prepareStatement(_sql);
		
		pstm.setString(1, dto.getName());
		pstm.setString(2, dto.getId());
		pstm.setString(3, dto.getJoindate());
		 
		int result = pstm.executeUpdate();
		pstm.close();
		conn.close();
		
		return result;
	}
}

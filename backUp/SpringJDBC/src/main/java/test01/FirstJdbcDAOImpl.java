package test01;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class FirstJdbcDAOImpl extends JdbcDaoSupport implements FirstJdbcDAO{

	@Override
	public int insert(String code, String name, int price, String maker) {
		String _insertSql = "insert into goodsinfo(code, name, price, maker) values(?,?,?,?)";
		
		return getJdbcTemplate().update(_insertSql, new Object[] {code, name, price, maker});
	}

	@Override
	public int delete(String name) {
		String _deleteSql = "delete from goodsinfo where name = ?";
		
		return getJdbcTemplate().update(_deleteSql, new Object[] { name });
	}

	@Override
	public void execute(String sql) {
		getJdbcTemplate().query(sql, new MyMapper<Object>());
	}
	
	class MyMapper<T> implements RowMapper<T> {

		@Override
		public T mapRow(ResultSet rs, int rowNum) throws SQLException {
			String code = rs.getString("CODE");
			String name = rs.getString("name");
			String maker = rs.getString("maker");
			int price = rs.getInt("price");
			
			System.out.printf("%10s %10s %10d %10s \n", code, name, price, maker);
			
			return null;
		}
	}
}
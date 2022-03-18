package test02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class FirstJdbcDAOImpl extends JdbcDaoSupport implements FirstJdbcDAO {

	@Override
	public List<GoodsVO> listGoods() {
		return getJdbcTemplate().query("select * from goodsinfo", new MyMapper());
	}

	@Override
	public GoodsVO findGoods(String code) {
		String _findSql = "select * from goodsinfo where code = ?";
		
		return getJdbcTemplate().queryForObject(_findSql, 
				new MyMapper<GoodsVO>(), new Object[] {code});
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		String _updateSql = "UPDATE GOODSINFO SET NAME = ?, PRICE = ?, MAKER = ? WHERE CODE = ?";
		return getJdbcTemplate().update(_updateSql, 
				new Object[] { vo.getName(), vo.getPrice(), vo.getMaker(), vo.getCode()});
	}
	
	class MyMapper<T> implements RowMapper<GoodsVO> {

		@Override
		public GoodsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			GoodsVO entity = new GoodsVO();
	        entity.setCode(rs.getString("code"));
	        entity.setName(rs.getString("name"));
	        entity.setPrice(rs.getInt("price"));
	        entity.setMaker(rs.getString("maker"));
	         
	        return entity;
		}
	}
}

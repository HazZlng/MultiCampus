package test03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("test")
@Repository
public class FirstJdbcDAOImpl implements FirstJdbcDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<GoodsVO> listGoods() {
		return jdbcTemplate.query("select * from goodsinfo", myMapper);
	}

	@Override
	public GoodsVO findGoods(String code) {
		String _findSql = "select * from goodsinfo where code = ?";
		
		return jdbcTemplate.queryForObject(_findSql, 
				myMapper, new Object[] {code});
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		String _updateSql = "UPDATE GOODSINFO SET NAME = ?, PRICE = ?, MAKER = ? WHERE CODE = ?";
		return jdbcTemplate.update(_updateSql, 
				new Object[] { vo.getName(), vo.getPrice(), vo.getMaker(), vo.getCode()});
	}
	
	private final RowMapper<GoodsVO> myMapper = (rs, rowNum) -> {

			GoodsVO entity = new GoodsVO();
	        entity.setCode(rs.getString("code"));
	        entity.setName(rs.getString("name"));
	        entity.setPrice(rs.getInt("price"));
	        entity.setMaker(rs.getString("maker"));
	         
	        return entity;	
	};
}

package test02;

import java.util.List;

public interface FirstJdbcDAO {
	List<GoodsVO> listGoods();
	GoodsVO findGoods(String code);
	int updateGoods (GoodsVO vo);
		
}

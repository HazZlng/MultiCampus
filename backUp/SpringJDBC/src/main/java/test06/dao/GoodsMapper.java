package test06.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import test06.GoodsVO;

public interface GoodsMapper {

	// 전체 출력
	@SelectProvider(type = GoodsProvider.class, method = "selectGoods")
	public List<GoodsVO> selectGoods();
	
	// 코드로 찾기
	@SelectProvider(type = GoodsProvider.class, method = "findGoods")
	public List<GoodsVO> findGoods(String code);
	
	// 객체 삽입
	@InsertProvider(type = GoodsProvider.class, method = "insertGoods")
	public Integer insertGoods(GoodsVO vo);
	
	// 객체 업데이트
	@UpdateProvider(type = GoodsProvider.class, method = "updateGoods")
	public Integer updateGoods(GoodsVO vo);
	
	// 객체 삭제
	@DeleteProvider(type = GoodsProvider.class, method = "deleteGoods")
	public Integer deleteGoods(String code);
}

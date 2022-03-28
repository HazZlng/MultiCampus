package test06.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import test06.GoodsVO;

public interface GoodsMapper {

	// ��ü ���
	@SelectProvider(type = GoodsProvider.class, method = "selectGoods")
	public List<GoodsVO> selectGoods();
	
	// �ڵ�� ã��
	@SelectProvider(type = GoodsProvider.class, method = "findGoods")
	public List<GoodsVO> findGoods(String code);
	
	// ��ü ����
	@InsertProvider(type = GoodsProvider.class, method = "insertGoods")
	public Integer insertGoods(GoodsVO vo);
	
	// ��ü ������Ʈ
	@UpdateProvider(type = GoodsProvider.class, method = "updateGoods")
	public Integer updateGoods(GoodsVO vo);
	
	// ��ü ����
	@DeleteProvider(type = GoodsProvider.class, method = "deleteGoods")
	public Integer deleteGoods(String code);
}

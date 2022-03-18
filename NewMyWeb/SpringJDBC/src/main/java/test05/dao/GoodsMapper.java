package test05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;

import test05.GoodsVO;

public interface GoodsMapper {
	
	//���ϰ�ü�� ��������� Ʈ�������� ��Ȱ�� ����ȴ�.
	@Results({
		@Result(property = "code", column = "code"),
		@Result(property = "name", column = "name"),
		@Result(property = "price", column = "price"),
		@Result(property = "maker", column = "maker")
	})
	
	// ��ü ���
	@Select("select * from goodsinfo")
	public List<GoodsVO> selectGoods();
	// �ڵ�� ã��
	@Select("select * from goodsinfo where code = #{code}")
	public List<GoodsVO> findGoods(String code);
	// ��ü ����
	@Insert("insert into goodsinfo(code, name, price, maker) \r\n"
			+ "  		values (#{code}, #{name}, #{price}, #{maker})")
	public int insertGoods(GoodsVO vo);
	// ��ü ������Ʈ
	@Update("update goodsinfo set name = #{name}, price = #{price}, maker = #{maker}\r\n"
			+ "  		where code = #{code}")
	public int updateGoods(GoodsVO vo);
	// ��ü ����
	@Delete("delete from goodsinfo where code = #{code}")
	public int deleteGoods(String code);
}

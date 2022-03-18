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
	
	//리턴객체를 생성해줘야 트랜젝션이 원활히 실행된다.
	@Results({
		@Result(property = "code", column = "code"),
		@Result(property = "name", column = "name"),
		@Result(property = "price", column = "price"),
		@Result(property = "maker", column = "maker")
	})
	
	// 전체 출력
	@Select("select * from goodsinfo")
	public List<GoodsVO> selectGoods();
	// 코드로 찾기
	@Select("select * from goodsinfo where code = #{code}")
	public List<GoodsVO> findGoods(String code);
	// 객체 삽입
	@Insert("insert into goodsinfo(code, name, price, maker) \r\n"
			+ "  		values (#{code}, #{name}, #{price}, #{maker})")
	public int insertGoods(GoodsVO vo);
	// 객체 업데이트
	@Update("update goodsinfo set name = #{name}, price = #{price}, maker = #{maker}\r\n"
			+ "  		where code = #{code}")
	public int updateGoods(GoodsVO vo);
	// 객체 삭제
	@Delete("delete from goodsinfo where code = #{code}")
	public int deleteGoods(String code);
}

package test06.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import test06.GoodsVO;

@Component
public class GoodsProvider {
		// 전체 출력
		public String selectGoods() {
			return new SQL() {
				{
					SELECT ( "CODE, NAME, PRICE, MAKER");
					FROM("GOODSINFO");
				}
			}.toString();
		}
		
		// 코드로 찾기
		public String findGoods(String code) {
			return new SQL() {
				{
					SELECT ( "CODE, NAME, PRICE, MAKER");
					FROM("GOODSINFO");
					WHERE("CODE = #{code}");
				}
				
			}.toString();
		}
		// 객체 삽입
		public String insertGoods(GoodsVO vo) {
			String _sql = new SQL().INSERT_INTO("GOODSINFO").
					VALUES("CODE, NAME, PRICE, MAKER", "#{code}, #{name}, #{price}, #{maker}").toString();
			return _sql;		
		}
		// 객체 업데이트
		public String updateGoods(GoodsVO vo) {
			String _sql = new SQL().UPDATE("GOODSINFO").
					SET("NAME = #{name}", "PRICE = #{price}", "MAKER = #{maker}").
					WHERE("CODE = #{code}").toString();
			return _sql;
		}
		// 객체 삭제
		public String deleteGoods(String code) {
			return new SQL() {
				{
					DELETE_FROM("GOODSINFO");
					WHERE("CODE = #{code}");
				}
				
			}.toString();
		}
	}


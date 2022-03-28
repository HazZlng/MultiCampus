package test06.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import test06.GoodsVO;

@Component
public class GoodsProvider {
		// ��ü ���
		public String selectGoods() {
			return new SQL() {
				{
					SELECT ( "CODE, NAME, PRICE, MAKER");
					FROM("GOODSINFO");
				}
			}.toString();
		}
		
		// �ڵ�� ã��
		public String findGoods(String code) {
			return new SQL() {
				{
					SELECT ( "CODE, NAME, PRICE, MAKER");
					FROM("GOODSINFO");
					WHERE("CODE = #{code}");
				}
				
			}.toString();
		}
		// ��ü ����
		public String insertGoods(GoodsVO vo) {
			String _sql = new SQL().INSERT_INTO("GOODSINFO").
					VALUES("CODE, NAME, PRICE, MAKER", "#{code}, #{name}, #{price}, #{maker}").toString();
			return _sql;		
		}
		// ��ü ������Ʈ
		public String updateGoods(GoodsVO vo) {
			String _sql = new SQL().UPDATE("GOODSINFO").
					SET("NAME = #{name}", "PRICE = #{price}", "MAKER = #{maker}").
					WHERE("CODE = #{code}").toString();
			return _sql;
		}
		// ��ü ����
		public String deleteGoods(String code) {
			return new SQL() {
				{
					DELETE_FROM("GOODSINFO");
					WHERE("CODE = #{code}");
				}
				
			}.toString();
		}
	}


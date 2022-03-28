package test04;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;


@Component("test00")
public class GoodsDAO {
	// 1. SqlSessionFactory -->>> ȯ�漳�� ������ ���� config�� mapper�� �������Ѵ�.
	private static SqlSessionFactory factory = null;
	static {
		try {
			String resource = "test04/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��ü ���
	public List<GoodsVO> selectGoods() {
		List<GoodsVO> result = null;
		
		try (SqlSession session = factory.openSession()) {
			result = session.selectList("mybatis.goodsMapper.selectGoods");
		}
		
		return result;
	}
	
	// �ڵ�� ã��
	public List<GoodsVO> findGoods(String code) {
		List<GoodsVO> result = null;
		
		try (SqlSession session = factory.openSession()) {
			result = session.selectOne("mybatis.goodsMapper.findGoods", code);
		}
		
		return result;
	}
	
	// ��ü ����
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		
		try (SqlSession session = factory.openSession()) {
			result = session.insert("mybatis.goodsMapper.insertGoods", vo);

			if(result > 0)
				session.commit();
			else 
				session.rollback();
		}
		
		return result;
	}
	
	// ��ü ������Ʈ
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		try (SqlSession session = factory.openSession()) {
			result = session.update("mybatis.goodsMapper.updateGoods", vo);
			
			if(result > 0)
				session.commit();
			else 
				session.rollback();
		}
		
		return result;
	}
	
	// ��ü ����
	public int deleteGoods(String code) {
		int result;
		
		try (SqlSession session = factory.openSession()) {
			result = session.delete("mybatis.goodsMapper.deleteGoods", code);
			
			if(result > 0)
				session.commit();
			else 
				session.rollback();
		}
		
		return result;
	}
}

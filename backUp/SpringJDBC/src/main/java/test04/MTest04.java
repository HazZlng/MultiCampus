package test04;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MTest04 {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("test04/applicationContext.xml");
		
		GoodsDAO dao = factory.getBean("test", GoodsDAO.class);
		
		List<GoodsVO> vo = dao.selectGoods();
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
		
		System.out.println("============================================================");
		
		dao.insertGoods(factory.getBean("vo01", GoodsVO.class));
		dao.insertGoods(factory.getBean("vo02", GoodsVO.class));
		
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
		
		System.out.println("============================================================");
		
		dao.updateGoods(factory.getBean("vo01", GoodsVO.class));
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
	}
}

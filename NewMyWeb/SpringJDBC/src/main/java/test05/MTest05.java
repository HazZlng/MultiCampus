package test05;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import test05.dao.*;


public class MTest05 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("test05/applicationContext.xml");
		
		GoodsDAO dao = factory.getBean("test", GoodsDAO.class);
		
		GoodsVO vo03 = new GoodsVO();
		vo03.setCode("p007");
		vo03.setName("Android");
		vo03.setPrice(56000);
		vo03.setMaker("³ª");
		
		
		List<GoodsVO> vo = dao.selectGoods();
		System.out.println("===========================SELECT ALL=================================");
		
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
		
		System.out.println("===========================INSERT INTO=================================");
		
		dao.insertGoods(factory.getBean("vo01", GoodsVO.class));
		dao.insertGoods(factory.getBean("vo02", GoodsVO.class));
		
		vo = dao.selectGoods();
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
		
		System.out.println("===========================UPDATE=================================");
		dao.updateGoods(vo03);		
		vo = dao.selectGoods();
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
		
		System.out.println("===========================DELETE=================================");
		
		dao.deleteGoods("p007");
		dao.deleteGoods("p008");
		
		vo = dao.selectGoods();
		for(GoodsVO result : vo) {
			System.out.println(result);
		}
	}
}

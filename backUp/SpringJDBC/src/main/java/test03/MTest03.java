package test03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest03 {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("test03/applicationContext.xml");

		FirstJdbcDAO dao = factory.getBean("test", FirstJdbcDAO.class);
		List<GoodsVO> list = dao.listGoods();

		for (GoodsVO vo : list) {
			System.out.printf("%10s %10s %10d %10s \n", vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker());
		}

		System.out.println("================================================================================");

		GoodsVO res = dao.findGoods("p0003");
		res.setMaker("111");
		res.setName("Ajax");
		res.setPrice(50000);
		int r = dao.updateGoods(res);
		if (r > 0) {
			List<GoodsVO> update_all= dao.listGoods();
			for (GoodsVO vo : update_all) {
				System.out.printf("%10s %10s %10d  %10s \n", vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker());
			}
		}

		((ClassPathXmlApplicationContext) factory).close();

	}

}

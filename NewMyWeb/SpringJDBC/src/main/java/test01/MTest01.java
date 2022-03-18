package test01;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest01 {
	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("test01/applicationContext.xml");
		
		FirstJdbcDAO dao = (FirstJdbcDAO)factory.getBean("test");
		int count = dao.insert("p0005", "������", 55000, "SDS");
		System.out.println(count + "���� �����Ͱ� �ԷµǾ����ϴ�.");
		
		dao.execute("SELECT * FROM GOODSINFO");
		System.out.println("===========================");
		int r = dao.delete("������");
		dao.execute("SELECT * FROM GOODSINFO");
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}

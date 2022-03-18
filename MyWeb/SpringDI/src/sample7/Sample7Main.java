package sample7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample7Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("sample7/applicationContext.xml");
		
		Parent obj = ac.getBean("child02", Parent.class);
		System.out.println(obj.getEmail());
		
		System.out.println("========================================");
		
		obj = ac.getBean("child", Parent.class);
		System.out.println(obj.getEmail());
		
		System.out.println("========================================");
		
		obj = ac.getBean("parent", Parent.class);
		System.out.println(obj.getEmail());
	}
} 

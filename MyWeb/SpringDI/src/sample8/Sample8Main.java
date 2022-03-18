package sample8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample2.Address;
public class Sample8Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("sample8/applicationContext.xml");
		
		System.out.println("========================================");
		Address a1 = ac.getBean("addr01", Address.class);
		System.out.println(a1);
		
		a1 = ac.getBean("addr02", Address.class);
		System.out.println(a1);
	} 
} 

package sample5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample5Main {
	public static void main(String[] args) {
		ApplicationContext factory
		= new ClassPathXmlApplicationContext("sample5/applicationContext.xml");

		TV tv = factory.getBean("samsung", TV.class);
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}
}



package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02Main {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext(
						"com/test02/applicationContext.xml");

		TV tv = factory.getBean("samsung", TV.class);
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}
}



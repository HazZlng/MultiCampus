package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		Person p = ac.getBean("student", Person.class);
		p.classWork();
		
		((AbstractApplicationContext)ac).close();
	}

}

package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class mTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) ctx).register(AppConfig.class);
		((AbstractApplicationContext) ctx).refresh();
		
		School st = ctx.getBean("school", School.class);
		System.out.println(st);
	} 

}

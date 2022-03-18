package com.test01.Anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
						new String[] {"com/test01/Anno/Beans.xml"});
		
		NicNamePrn prn = context.getBean("MyTest", NicNamePrn.class);
		System.out.print(prn);
	}

}

package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample4Main {
	public static void main(String[] args) {
		ApplicationContext factory
		= new ClassPathXmlApplicationContext("sample4/app.xml");

		AbstractTest bean = (AbstractTest) factory.getBean("test");

		System.out.println("오늘은  " + bean.dayInfo());

		//beans 객체를  소멸 하는 메소드  
		((ClassPathXmlApplicationContext) factory).close();

	}
}



package test01;

import java.lang.reflect.Method;

public class Test01_MTest {

	public static void main(String[] args) {

		Object obj = null;
		
		try {
			obj = Class.forName("com.test01.MyClass");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method[] mo = obj.getClass().getDeclaredMethods();
		for(Method res : mo) {
			Dan d = res.getAnnotation(Dan.class);
			System.out.println("적용된 내용을 확인 : " + d.value());
		}
	}
}

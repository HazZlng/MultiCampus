package com.test;

public class MTest01 {
	
	
	
	@FunctionalInterface
	interface Func01 {
		public String prn(String name);
	}
	
	@FunctionalInterface
	interface Func02 {
		public String prn02();
	}
	
	public static void main(String[] args) {
		Func01 m_name = name -> "hi ! " + name;		// (name)에서 ()를 생략
		System.out.println(m_name.prn("Steve_Ha"));
		
		Func02 m_test = () -> "lambda Test!";
		System.out.println(m_test.prn02());
		
		Func02 m_test02 = () -> { return "lambda Test!";};
		System.out.println(m_test02.prn02());
	}

}

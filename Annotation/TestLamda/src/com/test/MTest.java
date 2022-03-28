package com.test;

public class MTest {

	@FunctionalInterface
	private interface My_Function { // 함수인터페이스
		public void say(String name);// 추상메소드 하나만 선언
	}

	public static void main(String[] args) {
		My_Function func = (name) -> System.out.println("Hello, " + name);
		func.say("Dominica_kim");
		func.say("Steve_Ha");
	}
}

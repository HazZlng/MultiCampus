package com.test;

public class MTest {

	@FunctionalInterface
	private interface My_Function { // �Լ��������̽�
		public void say(String name);// �߻�޼ҵ� �ϳ��� ����
	}

	public static void main(String[] args) {
		My_Function func = (name) -> System.out.println("Hello, " + name);
		func.say("Dominica_kim");
		func.say("Steve_Ha");
	}
}

package com.test;

public class MTest02 {
	
	@FunctionalInterface
	interface Func{
		public int calc(int a, int b);
	}
	
	public static void main(String[] args) {
		Func add = (int a, int b) -> {
			return a + b;
		};
		
		Func sub = (int a, int b) -> a - b;
		
		Func mult = (a, b) -> a * b;
		
		Func div = (a, b) -> a / b;
		
		System.out.println(add.calc(200, 5));
		System.out.println(sub.calc(200, 5));
		System.out.println(mult.calc(200, 5));
		System.out.println(div.calc(200, 5));

	}
}

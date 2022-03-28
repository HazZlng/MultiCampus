package com.test02;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<MyConstructor> func = MyConstructor :: new ; 
//		Supplier<MyConstructor> func = () -> new MyConstructor(); 
		
		MyConstructor res = func.get();
		System.out.println(res);
		
		Function<String, MyConstructor> func1 = MyConstructor :: new;
//		Function<String, MyConstructor> func1 = (name) -> new MyConstructor();
		
		System.out.println(func1.apply("Steve_Ha"));
		
		BiFunction<String, Integer, MyConstructor> func3 = MyConstructor :: new;
//		BiFunction<String, Integer, MyConstructor> func3 = (name, age) -> new MyConstructor();
		
		System.out.println(func3.apply("hahaha", 14));
	}

}

class MyConstructor {
	private String name;
	int age;
	
	public MyConstructor() {
		name = "ȫ�浿";
		age = 20;
	}
	
	public MyConstructor(String name) {
		this.name = name;
	}
	
	public MyConstructor(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "MyConstructor [name=" + name + ", age=" + age + "]";
	}
}
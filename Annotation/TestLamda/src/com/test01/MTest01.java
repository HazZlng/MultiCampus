package com.test01;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiFunction<String, String, String> bi = (x, y) -> {
			return x + y;
		};
		
		Function<String, String> f = x -> x + " !";
		System.out.println(bi.andThen(f).andThen(f).apply("Getting Starg", "Java"));
	}

}

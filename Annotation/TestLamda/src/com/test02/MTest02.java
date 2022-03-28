package com.test02;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;

public class MTest02 {
	
	public static void main(String[] args) {
		String s = " Jdk ver_1.8";
		IntSupplier supplier = s::length;
		System.out.println(supplier.getAsInt());
		
		Consumer<String> c = System.out::println;
		c.accept("MySpring");
		
		IntBinaryOperator op = Integer::sum;
		System.out.println(op.applyAsInt(100, 200));
		
		Function<Integer, Double> r = Math::sqrt;
		System.out.println(r.apply(100));
	}
}

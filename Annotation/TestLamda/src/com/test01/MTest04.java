package com.test01;

import java.util.function.Consumer;

public class MTest04 {
	public static void main(String[] agrs) {
		Consumer<String>	c = s -> System.out.println(s);
		c.accept("abc");
		
		Consumer<String> c1 = s -> System.out.println("c1 = " + s);
		Consumer<String> c2 = s -> System.out.println("c2 = " + s);
		
		Consumer<String> res = c1.andThen(c2);
		res.accept("abc");
	}
}

package com.test01;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class MTest02 {
	
	
	public static void main(String[] args) {
		Predicate<String> i = s -> s.length() > 10;
		System.out.println(i.test("Getting Start Java"));
		
		IntPredicate p1 = n -> (n % 3) == 0;
		IntPredicate p2 = n -> (n % 5) == 0;
		IntPredicate pRes = p1.and(p2);
		
		System.out.println(pRes.test(3));
		System.out.println(pRes.test(4));
			
		IntPredicate pRes02 = p1.or(p2);
		System.out.println(pRes02.test(5));
		System.out.println(pRes02.test(15));
		
		Predicate<String> str = Predicate.isEqual("Steva_Ha");
		System.out.println(str.test("Steva_Ha"));
		
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		System.out.println(bi.test(5, 7));
	}
}

package com.test01;

import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class MTest05 {
	public static void main(String[] args) {
		IntUnaryOperator op1 = n -> n * 10; // 단항 연산 실행
		IntUnaryOperator op2 = n -> n + 1; // 단항 연산실행
		IntUnaryOperator op = op1.compose(op2); // (1)
		System.out.println(op.applyAsInt(2));

		UnaryOperator<String> op02 = UnaryOperator.identity(); // (2)
		System.out.println(op02.apply("aaa"));

		BinaryOperator<String> op03 = BinaryOperator.minBy((s1, s2) -> s1.compareTo(s2)); // (3)
		String s_res = op03.apply("aaa", "ddd");
		System.out.println("aaa,ddd 중 작은값 리턴 :" + s_res);

		BinaryOperator<String> op04 = BinaryOperator.maxBy((s1, s2) -> s1.compareTo(s2)); // (4)
		String s_res01 = op04.apply("aaa", "ddd");
		System.out.println("aaa,ddd 중 큰값 리턴 :" + s_res01);

	}
}



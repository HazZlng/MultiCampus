package com.test01;

import java.util.function.Function;

public class MTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, String> mFun = i -> Integer.toString(i);
		
		System.out.println(mFun.apply(100).length());
		System.out.println(mFun.apply(1000).length());


	}

}

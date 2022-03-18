package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("method "+invocation.getMethod()+" is called on "+
				invocation.getThis()+" with args "+invocation.getArguments());
		Object res = null;
		System.out.println("노트북 줌 로그인  후  실행 한다. 출석 체크 ");
		try {
			// 핵심로직
			res = invocation.proceed(); // G7_Class , Student classWork()

		} catch (Exception e) {
			System.out.println(" 멀티 캠퍼스 공사 하는 날  ");
		} finally {
			System.out.println(" 퇴실카드 체크.");
		}
		System.out.println("로그아웃 한다. ");		
 
           System.out.println("method "+invocation.getMethod()+" returns "+res);

		
		return res;
	}
}

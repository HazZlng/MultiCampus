package com.test05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAdvice")
@Aspect
public class MyAspect  {
	
	@Pointcut("execution(* classWork())")
	private void myClass() {
		
	}
	
	@Before("myClass()")
	public void before(JoinPoint joinpoint) {
		System.out.println("노트북 줌 로그인  후  실행 한다. 출석 체크");
	}
	
	@After("myClass()")
	public void after(JoinPoint joinpoint) {
		System.out.println("로그아웃 한다.");
	}
}


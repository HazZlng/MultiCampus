package com.test05;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements Person {

	@Override
	public void classWork() {
		System.out.println("학생은 회의실을 열고 줌 수업에 참여한다.");
	}

}

package com.test05;

import org.springframework.stereotype.Component;

@Component("g7")
public class G7_Class implements Person {

	@Override
	public void classWork() {
		System.out.println("노트북 줌 로그인 후 실행한다. 출석체크");
		
	}

}

package com.test01;

public class Student {
	public void classWork() {
		System.out.println("노트북 줌 로그인 후 실행한다. 출석체크");
		
		try
		{
			System.out.println("학생은 회의실을 열고 줌 수업에 참여한다.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("멀티 캠퍼스 공사하는 날");
		} finally {
			System.out.println("퇴실카드 체크");
		}
		System.out.println("로그아웃 한다.");
	}
}

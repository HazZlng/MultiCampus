package mc.ys.test;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// viewMonth 호출하세요
		CalendarTest ct = new CalendarTest();
		// 8월을 포함하여 1~12을 출력할 수 있도록 데이터를 전달하는 코드를
		// 추가하시오.
		ct.viewMonthFinalVersion(1992,2);
	}
	
	public void viewMonthFinalVersion(int year,int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		int space = cal.get(Calendar.DAY_OF_WEEK)-1;
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.printf("%d년 %d월 %n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int day = 1;
		for(int i=0;i<space;i++) {
			System.out.print("\t");
		}
		for(int i=0;i<lastDay;i++) {
			System.out.print(day+"\t");
			if((space+day)%7==0) {
				System.out.println();
			}
			day = day + 1;
		}
	}
	
	//메소드를 만들어서 위의 코드를 복사하세요
	//린턴타입과 파라메터가 없는 메소드 입니다.
	public void viewMonth(int month) {
		//빈칸정보와 마지막일수 정보는 spaces, lastDays라는 배열변수에 할당
		//해서 처리할 수 있도록 코드를 작성하세요
		int[] spaces = {5,1,1,4,6,2,4,0,3,5,1,3};
		int[] lastDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int space = spaces[month-1];
		int lastDay = lastDays[month-1];
		System.out.printf("2021년 %d월 %n",month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int day = 1;
		for(int i=0;i<space;i++) {
			System.out.print("\t");
		}
		for(int i=0;i<lastDay;i++) {
			System.out.print(day+"\t");
			if((space+day)%7==0) {
				System.out.println();
			}
			day = day + 1;
		}
	}
	
	public void viewMonthTest() {
		System.out.println("2021년 8월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int day = 1;
		for(int i=0;i<31;i++) { //i = i + 1;
			System.out.print(day+"\t");
			if(day%7==0) {//day==7||day==14||day==21||day==28
				System.out.println();
			}
			day = day + 1;
		}
	}
}



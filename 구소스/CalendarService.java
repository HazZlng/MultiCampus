package mc.ys.lesson1.test;

public class CalendarService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2020~2024년의 달력생성 --> 2019년 12월 빈칸정보 0
		int year = 2021;
		int month = 2;
		int[] spaces = new int[12];
		int[] lastDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int space = spaces[month-1];
		//윤년판단 로직
		int lastDay = lastDays[month-1];
		if(year%400==0 || (year%4==0&&year%100!=0)) {
			lastDay = 29;
		} 
		
		System.out.println("2022년 1월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0;i<space;i++) {
			System.out.print("\t");
		}
		int day = 1;
		for(int i=0;i<lastDay;i++) { 
			System.out.print(day+"\t");
			if((space+day)%7==0) {
				System.out.println();
			}
			day = day + 1;
		}
	}

}

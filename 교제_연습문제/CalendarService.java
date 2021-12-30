package mc.ys.lesson4;

public class CalendarService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2020~2024년의 달력생성 --> 2019년 12월 빈칸정보 0
		int year = 2020;
		int monthCount = 0;
		int firstDay = 0;
		int[] lastDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		//첫달의 첫 요일 구하기
		for(int i = 0; i < 31; i++)
		{
			firstDay++;
			if(firstDay == 7)
				firstDay = 0;
		}
		
		//5년간 모든 달력 출력
		for(int k = 0; k < 5; k++)
		{
			// 12달 전체 출력
			for(int j = 0; j < 12; j++)
			{
				//윤년판단 로직
				int lastDay = lastDays[j];
				if(year%400==0 || (year%4==0&&year%100!=0)) 
					lastDays[1] = 29;
				else
					lastDays[1] = 28;
				
				
				System.out.printf("%d년 %d월\n", year, j+1);
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				
				for(int i=0;i<firstDay;i++)
				{
					System.out.print("\t");
				}
				int day = 1;
				for(int i=0;i<lastDay;i++) 
				{ 
					firstDay++;
					if(firstDay == 7)
						firstDay = 0;
					
					System.out.print(day+"\t");
					if((firstDay)%7==0) 
					{
						System.out.println();
					}
					day = day + 1;
				}
				monthCount++;
				System.out.println();
			}
			monthCount = 0;
			year++;
		}
	}

}

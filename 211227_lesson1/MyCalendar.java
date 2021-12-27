package mc.ys.lesson1;


import java.util.Calendar;
import java.util.Scanner;

public class MyCalendar {
	static MyCalendar myCalendar = new MyCalendar();
	
	public static void main(String[] args)
	{
		myCalendar.starter();
	}
	
	public void starter()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			int yearInput;
			String monthInput;
			
			System.out.println("원하는 년도를 입력하세요.(2020년 ~ 2024년)");
			System.out.println("끝내려면 9999를 입력하세요.");
			
			yearInput = sc.nextInt();
			
			if(yearInput >= 2020 && yearInput <= 2024)
			{
				System.out.println("원하는 월을 입력하세요.");
				System.out.println("전체를 출력하려면 0을 입력하세요.");
				monthInput = sc.next();
				if(Integer.parseInt(monthInput) == 0)
				{
					for(int i = 1; i < 13; i++)
					{
						buildCalendar(yearInput, i);
					}
				}
				
				else if(Integer.parseInt(monthInput) >= 1 && Integer.parseInt(monthInput) <= 12)
					buildCalendar(yearInput, Integer.parseInt(monthInput));
					
				else
					System.out.println("월 범위를 벗어났습니다. 다시 입력하세요.");
			}
			
			else if(yearInput == 9999)
				break;
			
			else
				System.out.println("년도 범위를 벗어났습니다. 다시 입력하세요.");
		}
	}
	
	// 년도만 입력되었을시 호출됨, 전체 월의 달력을 빌드함.
	public void buildCalendar(int year)
	{
		for(int i = 1; i < 13; i++)
		{
			buildCalendar(year, i);
		}
	}
	
	// 년도와 달이 입력되었을시 오버라이드, 해당 월의 달력만 빌드함.
	public void buildCalendar(int year, int month)
	{
		Calendar c = Calendar.getInstance();
		int lastDay, dayOfWeek;
		
		c.set(year, month-1, 1);
		
		lastDay = c.getActualMaximum(Calendar.DATE);	//해당 월의 마지막날짜
		dayOfWeek = c.get(Calendar.DAY_OF_WEEK);		//

		System.out.println("========== " + year + "년 " + month + "월 ==========");
        System.out.println("  일   월   화  수   목  금   토  ");
        
        
        for(int i = 1; i <= lastDay; i++)
        {
        	if(i == 1)
        	{
        		for(int j = 0; j < dayOfWeek-1; j++)
        			System.out.print("  - ");
        	}
        	
        	if(i < 10)
        	    System.out.print("  " + i + " ");
        	
        	if(i >= 10)
        		System.out.print(" " + i + " ");
        	
        	if(dayOfWeek % 7 == 0)
        		System.out.println();
        	
        	dayOfWeek++;
        }
        System.out.println();
	}
}
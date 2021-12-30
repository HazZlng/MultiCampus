package mc.ys.lesson4;

import java.util.Scanner;

public class Ex4 {
	static Ex4 ex4 = new Ex4();
	
	public static void main(String[] args)
	{
		ex4.star1();		
		System.out.println();
		ex4.star2();
		System.out.println();
		ex4.ex4_4();
		System.out.println();
		ex4.ex4_5();
		System.out.println();
		ex4.ex4_6();
		System.out.println();
		ex4.ex4_7();
		System.out.println();
		ex4.ex4_8();
		System.out.println();
		ex4.ex4_9();
		System.out.println();
		ex4.ex4_10();
	}
	
	void star1()
	{
		System.out.println("--star1");

		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	void star2()
	{
		System.out.println("--star2");

		for(int i = 0; i < 6; i++)
		{
			for(int j = 6; j > i; j--)
				System.out.print("*");
			System.out.println();
		}
	}
	
	void ex4_4()
	{
		int sum = 0;
		int n = 1;
		
		System.out.println("--ex4_4");
		while(true)
		{
			if(n % 2 == 0)
				sum -= n;
			else
				sum += n;
			
			if(sum >= 100)
				break;
			n++;
		}
		System.out.println(n);
	}
	
	void ex4_5()
	{
		int aCount = 0;
		int bCount = 0;
		
		System.out.println("--ex4_5");
		
		while(aCount <= 10)
		{	
			while(bCount <= aCount)
			{
				System.out.print("*");
				bCount++;
			}
			System.out.println();
			bCount = 0;
			aCount++;
		}
	}
	
	void ex4_6()
	{
		System.out.println("--ex4_6");
		
		for(int i = 1; i < 7; i++)
		{
			for(int j = 1; j < 7; j++)
			{
				if(i+j == 6)
					System.out.print("( " + i + ", " + j + " )");
				else
					continue;
			}
		}
		System.out.println();
	}
	
	void ex4_7()
	{
		String str = "12345";
		int sum = 0;
		
		System.out.println("--ex4_7");
		
		for(int i = 0; i < str.length(); i++)
		{
			sum += Character.getNumericValue(str.charAt(i));
		}
		System.out.println(sum);
	}
	
	void ex4_8()
	{
		System.out.println("--ex4_8");

		int value = ((int)Math.random() * 10 + 1);
		System.out.println(value);
	}
	
	void ex4_9()
	{
		int num = 12345;
		int sum = 0;
		
		System.out.println("--ex4_9");

		for(int i = 0; i < (int)(Math.log10(num)+1); i++)
		{
			sum += (num % 10);
			num /= 10;
		}
		System.out.println(sum);
	}
	
	void ex4_10()
	{
		int answer = ((int)Math.random() * 100 + 1);
		int input = 0;
		int count = 0;
		
		System.out.println("--ex4_10");

		Scanner sc = new Scanner(System.in);
		do
		{
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = sc.nextInt();
			
			if(input == answer)
			{
				System.out.println("정답입니다.");
				System.out.printf("시도횟수는 %d번 입니다.\n", count);
				break;
			}
			else if(input < answer)
				System.out.println("더 높은 수를 입력하세요.");
			else
				System.out.println("더 낮은 수를 입력하세요.");
		} while(true);
	}
}

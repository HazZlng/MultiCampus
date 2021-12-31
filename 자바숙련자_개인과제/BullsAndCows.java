package mc.ys.lesson3;

import java.util.Random;
import java.util.Scanner;

/* 1. 시스템은 중복이 없는 0~9의 4자리 숫자를 생성한다. (첫 번쨰 숫자는 0이 아니어야 한다.)
 * 2. 게임 참가자는 임의의 4자리 숫자를 입력한다.
 * 3. 시스템은 입력된 4자리 수를 자신이 가지고 있는 수와 비교한다
 * 4. 이때 숫자와 위치가 같으면 스트라이크, 숫자는 같지만 위치가 다르면 볼로 판정한다.
 * 5. 4스트라이크가 나오면 승리, 중간에 기권시 패배
 *	>>각색1. 숫자'야구'이므로 기회는 9번으로 제한한다.
 *	>>각색2. 
 * */
public class BullsAndCows {

	static BullsAndCows bullsAndCows = new BullsAndCows();
	int playCount = 1;
	boolean result = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bullsAndCows.starter();
	}
	
	void starter()
	{
		GenerateSysNum generator = new GenerateSysNum();
		CompareNums compare = new CompareNums();
		
		Scanner sc = new Scanner(System.in);
		boolean isDuple = false;
		int nCount = 0;
		int[] ballCounts = new int[2];
		int[] userNums = new int[4];
		int[] sysNums = generator.getSysNums();
			
		
		
		//숫자 입력받기
		while(true)
		{
			if(nCount == 4)
				break;
			
			System.out.printf("숫자 4개를 입력하세요. 현재 %d 회\n", bullsAndCows.playCount);
			
			for(int i = 0; i <userNums.length; i++)
				userNums[i] = sc.nextInt();
			
			//숫자가 중복인지 확인
			for(int i = 0; i < nCount; i++)
			{
				if(sysNums[nCount] == sysNums[i])
				{
					System.out.println("중복입니다. 다시 입력해주세요.");
					isDuple = true;
					break;
				}
			}
			
			//중복이면 반복문 처음으로 이동
			if(isDuple == true)
			{
				isDuple = false;
				continue;
			}
			ballCounts = compare.getBallCounts(sysNums, userNums);
			printer(ballCounts);
			
			if(ballCounts[0] == 4)
			{
				System.out.println("승리!");
				return;
			}
			if(bullsAndCows.playCount == 10)
			{
				System.out.println("게임오버!");
				return;
			}
		}
	}
	
	void printer(int[] ballCounts)
	{
		System.out.println("Strike : " + ballCounts[0] + " Balls : " + ballCounts[1]);
		playCount++;
	}
}

// 시스템 숫자를 생성자에서 생성한다.
class GenerateSysNum {
	int[] sysNums = new int[4];
	
	GenerateSysNum()
	{
		Random random = new Random();
		int nCount = 0;
		while(true)
		{
			boolean isDuple = false;
			
			if(nCount == 4)
				break;
			
			sysNums[nCount] = random.nextInt(9);
			
			//첫 숫자가 0이면 다시 뽑기
			if(sysNums[0] == 0)
				continue;
			
			//숫자가 중복인지 확인
			for(int i = 0; i < nCount; i++)
			{
				if(sysNums[nCount] == sysNums[i])
				{
					isDuple = true;
					break;
				}
			}
			
			//중복이면 반복문 처음으로 이동
			if(isDuple == true)
			{
				isDuple = false;
				continue;
			}
			
			nCount++;
		}
	}
	
	//뽑힌 숫자들을 반환하는 메서드
	public int[] getSysNums()
	{
		return sysNums;
	}
}

//유저의 숫자와 시스템의 숫자를 비교하는 클래스
class CompareNums
{
	int[] ballCounts = new int[2];
	//유저의 숫자와 시스템의 숫자를 비교하여 볼카운트를 세는 매서드
	void compareNums(int[] sysNums, int[] userNums)
	{
		int strike = 0;
		int ball = 0;
		
		for(int i = 0; i < sysNums.length; i++)
		{
			for(int j = 0; j < userNums.length; j++)
			{
				if(sysNums[i] == userNums[i])
				{
					strike++;
					break;
				}
				else if(sysNums[i] == userNums[j])
					ball++;
			}
		}
		ballCounts[0] = strike;
		ballCounts[1] = ball;
	}
	
	//볼카운트를 리턴하는 매서드
	int[] getBallCounts(int[] sysNums, int[] userNums)
	{
		compareNums(sysNums, userNums);
		return ballCounts;
	}
}
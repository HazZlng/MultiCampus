package mc.ys.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * 로또 프로그램
 * 1. 로또번호는 총 6개를 추출한다.
 * 2. 6개 당첨시 1등, 5개 2등, 4개 3등, 3개 4등, 이외 꽝
 * 3. 랜덤객체를 사용해서 랜덤 정수값 6세트를 생성한다. (1 ~ 45 정수범위)
 * 4. 랜덤번호와 당첨번호를 비교하여 맞은 갯수를 카운트한 후 등수를 매긴다.
 * */

public class MyLotto {
	static MyLotto myLotto = new MyLotto();
	Compare compare = Compare.getInstance();
	WinningLotto wl = WinningLotto.getInstance();
	
	int lotto[] = new int[6];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myLotto.starter();
	}

	//내 추첨번호를 생성하는 매서드
	public void starter()
	{
		Random random = new Random();
		ArrayList<int[]> myLotto = new ArrayList<>();
		
		
		//내 번호를 추첨, 6회 반복 (로또용지 1장)
		for(int i = 0; i < 6; i++)
		{
			int nCount = 0;
			int myNumber[] = new int[6];
			while(true)
			{
				int n = random.nextInt(45) + 1;					//난수생성
				for(int j = 0; j < myNumber.length; j++)		//기존 추첨번호와의 중복값 체크
				{
					if(myNumber[j] == n)
					{
						continue;								//중복값 발생시 저장하지 않고 반복
					}
				}
				
				myNumber[nCount] = n;							//중복값이 발생하지 않았다면 추첨번호 저장
				nCount++;									//추첨번호 저장 카운트
				
				//6개의 번호를 추첨하면 while문 나오기
				if(nCount == 6)
					break;
			}
			myLotto.add(myNumber);
		}
		
		System.out.println("내 번호는 ");
		for(int i = 0; i < myLotto.size(); i++)
		{
			System.out.print("[");
			for(int j = 0; j < myLotto.get(i).length; j++)
			{
				System.out.print(" " + myLotto.get(i)[j] + " ");
			}
			System.out.println("]");
		}
		
		//callWinning();
		compare.compareLottos(myLotto, lotto);
	}
	
	/*
	public void callWinning()
	{
		WinningLotto wl = new WinningLotto();
		lotto = wl.getWinningNumber();
	}
	*/
}

// 로또 당첨번호를 추첨하는 클래스
class WinningLotto {
	private static WinningLotto wl = null;
	public int winningLotto[] = new int[6];
	
	public static WinningLotto getInstance()
	{
		if(wl == null) {
			wl = new WinningLotto();
		}
		return wl;
	}
	
	//클래스가 선언되면 생성자에서 당첨번호를 추출한다.
	WinningLotto()
	{
		Random random = new Random();
		int nCount = 0;
		
		while(true)
		{
			int n = random.nextInt(45) + 1;					//난수생성
			for(int i = 0; i < winningLotto.length; i++)	//기존 추첨번호와의 중복값 체크
			{
				if(winningLotto[i] == n)
				{
					continue;								//중복값 발생시 저장하지 않고 반복
				}
			}
			
			winningLotto[nCount] = n;						//중복값이 발생하지 않았다면 추첨번호 저장
			nCount++;										//추첨번호 저장 카운트
		
			//6개의 번호를 추첨하면 while문 나오기
			if(nCount == 6)
				break;
		}
	}
	
	//당첨번호를 반환하는 메서드
	public int[] getWinningNumber()
	{
		System.out.println("당첨번호는 : " + Arrays.toString(winningLotto));
		return winningLotto;
	}
}

//당첨번호와 내 로또번호를 비교하는 클래스
class Compare {
	private static Compare c = null;
	
	public static Compare getInstance()
	{
		if(c == null)
			c = new Compare()
	}
	public void compareLottos(ArrayList<int[]> myNum, int[] winningNum)
	{
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < myNum.size(); i++)
		{
			int winCount = 0;
			for(int j = 0; j < winningNum.length; j++)
			{
				if(myNum.get(i)[j] == winningNum[j])
				{
					winCount++;
				}
			}
			
			switch(winCount)
			{
			case 6:
				result.add("1등!");
				break;
				
			case 5:
				result.add("2등!");
				break;
				
			case 4:
				result.add("3등!");
				break;
				
			case 3:
				result.add("4등!");
				break;
				
			case 2:
				result.add("5등!");
				break;
				
			default:
				result.add("꽝!");
				break;
			}
		}
		printResult(result, myNum);
	}
	
	public void printResult(ArrayList<String> result, ArrayList<int[]> myNum)
	{
		for(int i = 0; i < result.size(); i++)
		{
			System.out.print("[");
			for(int j = 0; j < myNum.size(); j++)
			{
				System.out.print(" " + myNum.get(i)[j] + " ");
			}
			System.out.print("]");
			System.out.println(" " + result.get(i));
		}
	}
}
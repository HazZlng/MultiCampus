package mc.ys.lesson9.review;

import java.util.Random;
import java.util.Scanner;

public class Review9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Review9인스턴스 생성
		Review9 r9 = new Review9();
		//r9.sum(2, 3);
		//r9.shuffle();
		//int[] a = {5,3,4,1,2};
		r9.sort(new int[]{5,3,4,1,2});
	}
	
	//swap메소드 생성해 보세요
	public void swap(int[] numbers, int idx1, int idx2) {
		int temp = numbers[idx1];
		numbers[idx1] = numbers[idx2];
		numbers[idx2] = temp;
	}
	
	public void inputTest() {
		//배열을 표준입력장치를 통해서 만들 것임.
		// Scanner 클래스를 이용해 표준입력장치에서 입력을 받은 것임.
		// 인스턴스 생성하세요
		Scanner scan = new Scanner(System.in);
		//입력받아서 배열에 대입할 것임. --> 이미 배열이 만들어져 있어야 함.
		// 입력할 갯수를 먼저 결정해서 배열을 생성하고 난 뒤에 입력하겠다.
		// 갯수 입력
		System.out.print("사용할 배열의 크기를 입력하세요 >>> ");
		int size = scan.nextInt();
		int[] abc = new int[size];
		// 갯수만큼 데이터(원소)를 입력받아야 함.
		for(int i=0;i<size;i++) {
			System.out.print("사용할 정수 데이터를 입력하세요 >>> ");
			abc[i] = scan.nextInt();
		}
		System.out.println("입력이 완료되었습니다.");
		this.print(abc);
		this.sort(abc);
		scan.close();
	}
	public void sort(int[] numbers) {
		
		//선택 정렬
		for(int k=0;k<numbers.length-1;k++) {
			for(int i=k+1;i<numbers.length;i++) {
				if(numbers[k]>numbers[i]) {
					int temp = numbers[k];
					numbers[k] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
		
//		for(int i=2;i<numbers.length;i++) {
//			if(numbers[1]>numbers[i]) {
//				int temp = numbers[1];
//				numbers[1] = numbers[i];
//				numbers[i] = temp;
//			}
//		}
		
		
		this.print(numbers);
	}
	
	public void shuffle() {
		int[] numbers = {1,2,3,4,5,6,7,8,9,0};
		//위의 numbers배열의 순서를 섞는 코드를 작성하시오
		for(int i=0;i<10;i++) {
			// 두개의 인덱스를 결정(Random으로 한다)
			Random r = new Random();
			int idx1 = r.nextInt(10); // 0~9
			int idx2 = r.nextInt(10);
			// 결정된 인덱스를 기준으로 교환로직 작성
			int temp = numbers[idx1];
			numbers[idx1] = numbers[idx2];
			numbers[idx2] = temp;
			this.print(numbers);
		}
	}
	
	public void print(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.printf("%d ",numbers[i]);
		}
		System.out.println();
	}
	
	//두수 사이의 수(두수는 포함)에 대해 합계를 구하는 메소드 선언을 하시오
	public void sum(int n, int m) {
		int total = 0;
		if(n>m) {
			//교환로직
			int temp = n;
			n = m;
			m = temp;
		}
		for(int i=n;i<m+1;i++) { //0~9까지의 수
			total = total + i; //누적
		}
		System.out.println(total);
	}

}

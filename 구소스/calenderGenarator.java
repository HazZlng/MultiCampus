package mc.ys.s1309.test;
import java.util.Scanner; 
import java.util.Date;

public class calenderGenarator {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("년도를 입력해주세요.>");
			String input = "";
			input = sc.nextLine();
			int year = Integer.parseInt(input);
			System.out.print("월을 입력해주세요.>");
			input = sc.nextLine();
			if(input == "") {
				for(int i=1; i<13; i++) {
					calenderPrint(year, i);
				}
			}else {
				int month = Integer.parseInt(input);
				calenderPrint(year, month);
			}
		}
	}
	public static void calenderPrint(int year, int month) {
		Date date = new Date();
		int start_index = 0;
		int end_index = 0;
		int day_count = 1;
		date.setYear(year);
		date.setMonth(month);
		date.setDate(1);
		switch(date.getDay()) {
			case 0:
				start_index = 3;
				break;
			case 1:
				start_index = 4;
				break;
			case 2:
				start_index = 5;
				break;
			case 3:
				start_index = 6;
				break;
			case 4:
				start_index = 0;
				break;
			case 5:
				start_index = 1;
				break;
			case 6:
				start_index = 2;
				break;
		} 

		date.setMonth(month+1);
		date.setDate(0);
		end_index = date.getDate();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("_____________________________________________");
		System.out.println("                  " + Integer.toString(year) + "년 " + Integer.toString(month) + "월");
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("|  일  |  월  |  화  |  수  |  목  |  금  |  토  |");
		System.out.println("---------------------------------------------");
		String[][] field = new String[6][7];
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				if(start_index > 0) {
					field[i][j] = "--일 |";
					start_index--;
				}
				else if(end_index < day_count) {
					field[i][j] = "--일 |";
				}
				else {
					field[i][j] = Integer.toString(day_count) + "일 |";
					if(field[i][j].length() <  5) {
						field[i][j] = "0" + field[i][j];
					}
					day_count++;
				}
					
			}
		}
		for(int i=0; i<6; i++) {
			System.out.print("| ");
			for(int j=0; j<7; j++) {
				System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("_____________________________________________");
		System.out.println();
		System.out.println();
		System.out.println();
	}
}

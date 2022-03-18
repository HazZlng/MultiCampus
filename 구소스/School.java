package mc.ys.lesson4;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School school = new School();
		school.test1();
	}
	
	public void test1() {
		String studentKim = "kim,39,49,59";
		String studentLee = "lee, 48,89,64";
		String studentPark = "park,90,81,100";
		
		String[] scores = {studentKim,studentLee,studentPark};
		System.out.println("name kor eng math total avg");
		System.out.println("=============================");
		for(int i=0;i<scores.length;i++) {
			String[] temp = scores[i].split(",");
			String name = temp[0];
			int kor = 0;
			int eng = 0;
			int math = 0;
			try {
				kor = Integer.parseInt(temp[1].trim());
				//int kor = Integer.parseInt(temp[1].trim());
				eng = Integer.parseInt(temp[2].trim());
				math = Integer.parseInt(temp[3].trim());
			} catch(NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
			StudentVO result = new StudentVO(name,kor,eng,math);
			System.out.println(result);
//			int total = result.getTotal();
//			double avg = result.getAvg();
			//System.out.printf("total is %d avg is %.2f %n", total, avg);
		}

	}

}

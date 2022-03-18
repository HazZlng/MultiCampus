package mc.ys.lesson7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class GisaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GisaTest gt = new GisaTest();
		//gt.testString();
		gt.testStart();
		
	}
	
	public void testStart() {
		//데이터준비
		try {
			//file의 데이터를 ArrayList로 만들어서 준비
			this.solveOne();
			this.solveTwo();
			this.solveThree();
			this.solveFour();
		} catch(FileNotFoundException ie) {
			System.out.println("정답작성중 FNF에러");
		} catch(IOException e) {
			System.out.println("정답작성중 IO에러");
		}
	}
	
	
	private void solveOne() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GisaDataVO> list = this.readyData();
		ArrayList<GisaDataVO> temp = new ArrayList<GisaDataVO>();
		//지역코드 B인 것만 따로 리스트로 구성
		for(GisaDataVO vo : list) {
			if(vo.getLocCode().equals("B")) {
				temp.add(vo);
			}
		}
		
		Collections.sort(temp, new MyComparator());
		int answer = temp.get(4).getStdNo();
		
		this.writeAnswer(String.valueOf(answer), 1);
		//this.print(temp);
		
		
	}

	private void print(ArrayList<GisaDataVO> temp) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			GisaDataVO vo = temp.get(i);
			System.out.println(vo);
		}
	}

	private void solveThree() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GisaDataVO> list = this.readyData();
		String answer = null;
		int sum = 0; //총점+point 누계
		for(GisaDataVO vo : list) {
			int point = 20; //담임코드 C의 값으로 초기화
			if(vo.getEng()+vo.getMath()>=120) {
				if(vo.getMgrCode().equals("A")) {
					point = 5;
				} else if(vo.getMgrCode().equals("B")) {
					point = 15;
				}
				int total = vo.getTotal()+point; //총점+point
				sum = sum +total;
			}
			
		}
		answer = String.valueOf(sum);
		this.writeAnswer(answer, 3);
	}

	private void solveFour() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GisaDataVO> list = this.readyData();
		String answer = null;
		int count = 0; //누적을 저장하는 변수
		for(GisaDataVO vo : list) {
			int point = 15; //지역코드 C의 값으로 초기화
			if(vo.getAccCode().equals("A")||vo.getAccCode().equals("B")) {
				if(vo.getLocCode().equals("A")) {
					point = 5;
				} else if(vo.getLocCode().equals("B")) {
					point = 10;
				}
				int total = vo.getKor()+point;
				if(total>=50) {
					count++;//count += 1, count = count + 1
				}
			}
			
		}
		answer = String.valueOf(count);
		this.writeAnswer(answer, 4);
	}

	private void writeAnswer(String answer,int order) throws IOException { //1~4번까지 모두 사용
		// TODO Auto-generated method stub
		// 해당하는 정답을 파일에 작성한다.
		String filePath = "./data/Ans"+order+".txt";
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(answer);
		pw.close();
		fw.close();
	}

	private void solveTwo() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<GisaDataVO> list = this.readyData();
		String answer = null;
		// 해당하는 문제를 해결하는 로직 작성(최대값 로직)
		int max = 0;
		GisaDataVO vo = null;
		for(int i=0;i<list.size();i++) {
			vo = list.get(i);
			if(vo.getLocCode().equals("B")) {
				if(max<(vo.getKor()+vo.getEng())) {
					max = vo.getKor()+vo.getEng();
				}
			}
		}
		answer = String.valueOf(max);
		this.writeAnswer(answer, 2);
	}
	private void solveTwoV2() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GisaDataVO> list = this.readyData();
		String answer = null;
		// 해당하는 문제를 해결하는 로직 작성(최대값 로직)
		int max = 0;
		for(GisaDataVO vo : list) {
			if(vo.getLocCode().equals("B")) {
				int temp = vo.getKor()+vo.getEng();
				max = max<temp?temp:max; 
			}
		}
		answer = String.valueOf(max);
		this.writeAnswer(answer, 2);
	}

	private ArrayList<GisaDataVO> readyData() throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		ArrayList<GisaDataVO> list = new ArrayList<GisaDataVO>();
		// 파일의 1000라인의 정보를 GisaDataVO를 이용하여 인스턴스로 만들고 ArrayList에 저장
		// 파일에 접속해서 스트림에 연결
		File file = new File("./data/Abc1115.txt");
		FileReader fr = new FileReader(file);
		// 한줄씩 읽기
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		GisaDataVO vo = null;
		while((line=br.readLine())!=null) {
			//한줄을 분석해서
			int stdNo = Integer.parseInt(line.substring(0,6));
			String email = line.substring(6,10);
			int kor = Integer.parseInt(line.substring(10,13).trim());
			int eng = Integer.parseInt(line.substring(13,16).trim());
			int math = Integer.parseInt(line.substring(16,19).trim());
			int sci = Integer.parseInt(line.substring(19,22).trim());
			int hist = Integer.parseInt(line.substring(22,25).trim());
			int total = Integer.parseInt(line.substring(25,28).trim());
			String mgrCode = line.substring(28,29);
			String accCode = line.substring(29,30);
			String locCode = line.substring(30,31);
			// VO객체에 할당하고 
			vo = new GisaDataVO();
			vo.setStdNo(stdNo);
			vo.setEmail(email);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setSci(sci);
			vo.setHist(hist);
			vo.setTotal(total);
			vo.setMgrCode(mgrCode);
			vo.setAccCode(accCode);
			vo.setLocCode(locCode);
			//리스트에 저장(리스트는 이미 존재해야 함)
			list.add(vo);
		}
		br.close();
		fr.close();
		return list;
	}

	public void testString() {
		String line = "990001addx 17 29 16 49 43154CAC";
		             //0123456789012345678901234567890
		//6 4 3 3 3 3 3 3 1 1 1
		//학번과 국어점수를 분리하여 지시문에서 선언된 타입으로 변수에 할당하시오.
		int stdNo = Integer.parseInt(line.substring(0,6));
		int kor = Integer.parseInt(line.substring(10,13).trim());
		System.out.printf("stdNo = %d kor = %d %n", stdNo,kor);
	}

}



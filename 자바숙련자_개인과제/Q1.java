package mc.ys.lesson6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 지역코드가 B인 자료에 대하여 (국어점수 + 영어점수)로 내림차순 정렬했을 때 5번째 학번을 출력하시오.
 * 동일 값 발생 시 학번에 대한 오름차순으로 청렬하시오
 * 출력경로 : C:\C_it\data\Ans1.txt
 */

public class Q1 {
	static Q1 q1 = new Q1();
	ReadFile rf = ReadFile.getInstance();
	FileDistributer fd = FileDistributer.getInstance();
	ArrayList<GisaDataVO> list = new ArrayList<GisaDataVO>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		q1.starter();
	}
	
	void starter() throws IOException
	{
		File file = rf.getFile();
		list = fd.readyData(file);
		list = q1.ans01(list);
		q1.fileExport(list);
	}
	
	//문제 1번 로직
	ArrayList<GisaDataVO> ans01(ArrayList<GisaDataVO> list)
	{
		//내부정렬 호출
		Collections.sort(list, new ScoreComparator());

		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		return list;
	}
	
	void fileExport(ArrayList<GisaDataVO> list) throws IOException 
	{
		String filePath = "C:\\C_it\\data\\Ans.txt";
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(list.get(4));
		pw.close();
		fw.close();
	}
}

//파일 읽기
class ReadFile{
	private static ReadFile rf = null;
	
	public static ReadFile getInstance()
	{
		if(rf == null)
			rf = new ReadFile();
		
		return rf;
	}
	
	//파일객체를 반환하는 메소드
	File getFile()
	{
		File file =new File("C:\\C_it\\data\\Abc1115.txt");
		
		if(file != null)
			System.out.println("File read complete! " + file);
		
		return file;
	}

}

//파일내용 분배하기
class FileDistributer{
	private static FileDistributer fd = null;
	
	public static FileDistributer getInstance()
	{
		if(fd == null)
			fd = new FileDistributer();
		
		return fd;
	}
	
	//파일객체를 입력받아 한줄씩 문자열로 저장하고 반환하는 메소드
	// 990001addx 17 29 16 49 43154CAC
	ArrayList<GisaDataVO> readyData(File file)
	{
		ArrayList<GisaDataVO> list = new ArrayList<GisaDataVO>();
		try {
			FileReader fr = new FileReader(file);				//입력스트림 생성
			BufferedReader br = new BufferedReader(fr);			//입력버퍼 생성
			String line = "";
			GisaDataVO vo = null;
			
            while((line = br.readLine()) != null)
            {
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
}

class GisaDataVO implements Comparable<GisaDataVO> {
	private int stdNo;
	private String email;
	private int kor;
	private int eng;
	private int math;
	private int sci;
	private int hist;
	private int total;
	private String mgrCode;
	private String accCode;
	private String locCode;
	//생성자, getter/setter, toString() 오버라이드
	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	public int getHist() {
		return hist;
	}
	public void setHist(int hist) {
		this.hist = hist;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getMgrCode() {
		return mgrCode;
	}
	public void setMgrCode(String mgrCode) {
		this.mgrCode = mgrCode;
	}
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("stdNo= %d, kor = %d, eng = %d, locCode = %s",stdNo,kor,eng,accCode);
	}
	
	//외부정렬 메소드 => 학번순
	@Override
	public int compareTo(GisaDataVO vo) {
		// TODO Auto-generated method stub
		int result = 0;
		if(this.stdNo < vo.stdNo)
			result = 1;
		else if(this.stdNo > vo.stdNo)
			result = -1;
		return result;
	}
	
}
class ScoreComparator implements Comparator<GisaDataVO>{
	
	//내부정렬 메소드 => 점수순
	@Override
	public int compare(GisaDataVO vo1, GisaDataVO vo2) {
		// TODO Auto-generated method stub
		int result = 0;
		if((vo1.getKor()+vo1.getEng())<(vo2.getKor()+vo2.getEng()))
			result = 1;
				
		else if((vo1.getKor()+vo1.getEng())>(vo2.getKor()+vo2.getEng()))
			result = -1;
		
		//점수가 같을 시 외부정렬 호출
		if(result == 0)
			result = vo1.compareTo(vo2);
		
		return result;
	}
}

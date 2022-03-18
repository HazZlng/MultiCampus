package mc.ys.lesson7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileCopy fc = new FileCopy();
		try {
			fc.copyFileV3();
		} catch(IOException e) {
			System.out.println("복사중 문제 발생");
		}
		
	}
	public void copyFileV3() throws IOException {
		File srcFile = new File("./data/Abc1115.txt");
		File destFile = new File("./data/CopyAbc1115UsingStream.txt");
		//ctrl+shift+O --> 자동 import
		FileInputStream fis = new FileInputStream(srcFile);
		
		FileOutputStream fos = new FileOutputStream(destFile);
		
		byte[] data = new byte[256];
		System.out.println("복사를 시작합니다.");
		long start = System.currentTimeMillis();
		while((fis.read(data))!=-1) { //-1은 파일의 끝이다라는 의미
			//복사하는 코드
			fos.write(data,0,data.length);
		}
		long end = System.currentTimeMillis();
		fis.close();
		fos.close();
		System.out.println("복사가 끝났습니다.");
		System.out.printf("%d millis가 소요되었습니다.", (end-start));
	
	}
	public void moveFile() throws IOException {
		File srcFile = new File("./data/nvm-setup.zip");
		File destFile = new File("./data/nvm-setupCopy.zip");
		//ctrl+shift+O --> 자동 import
		FileInputStream fis = new FileInputStream(srcFile);
		
		FileOutputStream fos = new FileOutputStream(destFile);
		
		byte[] data = new byte[256];
		System.out.println("복사를 시작합니다.");
		long start = System.currentTimeMillis();
		while((fis.read(data))!=-1) { //-1은 파일의 끝이다라는 의미
			//복사하는 코드
			fos.write(data,0,data.length);
		}
		long end = System.currentTimeMillis();
		fis.close();
		fos.close();
		System.out.println("복사가 끝났습니다.");
		srcFile.delete();
		System.out.printf("%d millis가 소요되었습니다.", (end-start));
			
	}
	public void copyFile2() throws IOException {
		//singleton.PNG 를 복사한다.
		File srcFile = new File("./data/nvm-setup.zip");
		File destFile = new File("./data/nvm-setupCopy.zip");
		//ctrl+shift+O --> 자동 import
		FileInputStream fis = new FileInputStream(srcFile);
		
		FileOutputStream fos = new FileOutputStream(destFile);
		
		byte[] data = new byte[256];
		System.out.println("복사를 시작합니다.");
		long start = System.currentTimeMillis();
		while((fis.read(data))!=-1) { //-1은 파일의 끝이다라는 의미
			//복사하는 코드
			fos.write(data,0,data.length);
		}
		long end = System.currentTimeMillis();
		fis.close();
		fos.close();
		System.out.println("복사가 끝났습니다.");
		System.out.printf("%d millis가 소요되었습니다.", (end-start));
	
	}
	
	public void copyFile() throws IOException {
		//singleton.PNG 를 복사한다.
		File srcFile = new File("./data/singleton.PNG");
		File destFile = new File("./data/singletonCopy.PNG");
		//ctrl+shift+O --> 자동 import
		FileInputStream fis = new FileInputStream(srcFile);
		
		FileOutputStream fos = new FileOutputStream(destFile);
		
		int data = 0;
		System.out.println("복사를 시작합니다.");
		while((data=fis.read())!=-1) { //-1은 파일의 끝이다라는 의미
			//복사하는 코드
			fos.write(data);
		}
		
		fis.close();
		fos.close();
		System.out.println("복사가 끝났습니다.");
	
	}

}

package sample10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class sample10MTest {
	
	public static void main(String[] args)
	{
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("sample10/applicationContext.xml");
		
		MemberDAO memberdao = factory.getBean("memberDAO", MemberDAO.class);
		MemberDTO memberdto = new MemberDTO("111", "111", "111");
		
		try {
			int r = memberdao.getInsert(memberdto);
			if(r > 0) {
				System.out.println("입력 성공");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

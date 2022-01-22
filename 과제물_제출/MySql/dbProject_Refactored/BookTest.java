package dbProject_Refactored;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookTest bt = new BookTest();
		BookDTO dto = new BookDTO("B004", "자바스크립트", "강길동", 2020, 28000, "서울출판사");
		BookDAO dao = new BookDAO("com.mysql.jdbc.Driver");
		
		dao.insertBook(dto);
		bt.printDB(dao.selectBook());
	}
	
	public void printDB(ArrayList<BookDTO> dto)
	{
		for(int i = 0; i < dto.size(); i++)
		{
			System.out.printf("%s %s %s %d %d %s \n", dto.get(i).getBookNo(), dto.get(i).getBookTitle(), dto.get(i).getBookAuthor()
					, dto.get(i).getBookYear(), dto.get(i).getBookPrice(), dto.get(i).getBookPublisher());
		}
	}
}

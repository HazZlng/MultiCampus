package dbProject;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDTO dto = new BookDTO("B004", "자바스크립트", "강길동", 2020, 28000, "서울출판사");
		BookDAO dao = new BookDAO("com.mysql.jdbc.Driver");
		
		dao.insertBook(dto);
		dao.selectBook();
	}
}

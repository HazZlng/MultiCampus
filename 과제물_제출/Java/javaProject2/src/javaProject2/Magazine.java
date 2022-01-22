package javaProject2;

public class Magazine extends Book {
	int month;
	
	Magazine(String bookNo, String bookTitle, String bookAuthor,
			String bookYear, String bookPrice, String bookPublisher, int month)
	{
		super(bookNo, bookTitle, bookAuthor, 
				bookYear, bookPrice, bookPublisher);
		this.month = month;
	}
	
	String getData()
	{
		String result = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%d",
				bookNo,bookTitle,bookAuthor,bookYear,bookPrice, bookPublisher, month);	
		return result;
	}
}

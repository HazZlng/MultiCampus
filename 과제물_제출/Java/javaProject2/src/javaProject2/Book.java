package javaProject2;

public class Book {
	String bookNo;
	String bookTitle;
	String bookAuthor;
	String bookYear;
	String bookPrice;
	String bookPublisher;
	
	Book(String bookNo, String bookTitle, String bookAuthor,
			String bookYear, String bookPrice, String bookPublisher){
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
	}
	
	String getData()
	{
		String result = String.format("%s\t%s\t%s\t%s\t%s\t%s",
				bookNo,bookTitle,bookAuthor,bookYear,bookPrice, bookPublisher);	
		return result;
	}
}

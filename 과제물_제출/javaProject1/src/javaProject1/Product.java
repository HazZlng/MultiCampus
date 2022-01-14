package javaProject1;

public class Product {
	int prdNo;
	String prdName;
	int prdPrice;
	int prdYear;
	String prdMaker;
	
	Product(int prdNo, String prdName, 
			int prdPrice, int prdYear, String prdMaker){
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdYear = prdYear;
		this.prdMaker = prdMaker;
	}
	
	String getData()
	{
		String result = String.format("%03d\t%3s\t%d\t%4d\t%s",
				prdNo,prdName,prdPrice,prdYear,prdMaker);	
		return result;
	}
}

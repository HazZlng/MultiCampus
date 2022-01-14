package javaProject1;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product(001, "노트북", 1200000, 2021, "삼성");
		Product p2 = new Product(002, "모니터", 300000, 2021, "LG");
		Product p3 = new Product(003, "마우스", 30000, 2020, "로지텍");
		
		System.out.println("상품번호\t상품명\t가격\t연도\t제조사");
		System.out.println("=====================================");
		System.out.println(p1.getData());
		System.out.println(p2.getData());
		System.out.println(p3.getData());
	}

}

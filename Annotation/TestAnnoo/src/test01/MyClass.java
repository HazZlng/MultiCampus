package test01;

public class MyClass {
	@Dan("7")
	public void PrnGuGudan(int dan) {
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" +
					i + "=" + (dan*i));
		}
	}
}

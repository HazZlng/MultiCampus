package sample2;

//has a ?울옙?⑨옙 [占쎄문占쎄쉐占쎌, setter]嚥∽옙 揶占?占쎌억옙? 獄占?癰占썲占?public class ListAddress {

	private Address addr;
	
	public ListAddress() {
		super();
		System.out.println("ListAddress 疫꿸?? 占쎄문占쎄쉐占쎌 ");
	}

	public ListAddress(Address addr) {
		super();
		this.addr = addr;
		System.out.println("ListAddress 筌?븐뻣占쎌ㅿ옙? 占쎄문占쎄쉐占쎌 ");
	}

	public Address getAddr() {
		return addr; // addr.toString();
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
}

package com.test;

/*
 * 
 */
		
		
public class Address {
	private String name;
	private String addr;
	private String tel;
	
	public Address() {
		super();
	}
	
	public Address(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Address [name=" + name + ", Addr=" + addr + ", tel=" + tel + "]";
	}
	
}

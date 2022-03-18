package com.test03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:/com/test03/AppConfig")
public class Student {
	
	@Value("${myname}")
	private String name;
	@Value("${myaddr}")
	private String address;
	@Value("${myage}")
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
}

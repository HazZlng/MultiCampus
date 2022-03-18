package com.test02;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV {
	SamsungTV()
	{
		super();
		System.out.println("SamsungTV 객체생성");
	}
	public void powerOn()
	{
		System.out.println("SamsungTV 전원 On!");
	}
	public void powerOff()
	{
		System.out.println("SamsungTV 전원 Off!");
	}
	public void volumnUp()
	{
		System.out.println("SamsungTV 전원 volumnUp!");
	}
	public void volumnDown()
	{
		System.out.println("SamsungTV 전원 volumnDown!");
	}
}

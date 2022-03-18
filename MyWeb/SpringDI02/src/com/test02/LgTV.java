package com.test02;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component("lg")
public class LgTV implements TV{
	LgTV()
	{
		super();
		System.out.println("LG TV 객체생성");
	}
	public void powerOn()
	{
		System.out.println("LG TV 전원 On!");
	}
	public void powerOff()
	{
		System.out.println("LG TV 전원 Off!");
	}
	public void volumnUp()
	{
		System.out.println("LG TV 전원 volumnUp!");
	}
	public void volumnDown()
	{
		System.out.println("LG TV 전원 volumnDown!");
	}
}

package com.test01.Anno;

import org.springframework.stereotype.Component;

@Component
public class NicName {
	NicName nicName;
	
	public void setNicName(NicName nicName) {
		this.nicName = nicName;
	}

	@Override
	public String toString() {
		return "NicName [HaZZinG]";
	}
	
}

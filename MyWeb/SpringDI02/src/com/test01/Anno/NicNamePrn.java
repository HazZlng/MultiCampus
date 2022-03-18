package com.test01.Anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyTest")
public class NicNamePrn {
	
	@Autowired
	NicName nicName;

//	public void setNicName(NicName nicName) {
//		this.nicName = nicName;
//	}

	@Override
	public String toString() {
		return "NicNamePrn [nicName=" + nicName + "]";
	}
	
	
}

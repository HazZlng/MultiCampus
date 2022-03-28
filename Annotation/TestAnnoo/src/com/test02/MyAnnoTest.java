package com.test02;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.EnumSet;
import java.util.Iterator;

public class MyAnnoTest {

	public enum myEnum{
		@MyAnno("1")
		X1, X2, X3 
	};
	public static EnumSet<myEnum> result
		= EnumSet.of(myEnum.X1, myEnum.X2);
	
	public static void main(String[] args) {
		MyAnnoTest my = new MyAnnoTest();
		
		try {
			Field field = my.getClass().getField("result");
			System.out.println(field);
			
			ParameterizedType pt = (ParameterizedType)field.getGenericType();
			System.out.println(pt);
			
			System.out.printf("\ngetRawType = %s \n"
					+ "getOwnderType = %s \n"
					+ "getActualTypeArguments = %s \n",
					pt.getRawType(),
					pt.getOwnerType(),
					pt.getActualTypeArguments());
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("===================================");
		Iterator ir = result.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}

}

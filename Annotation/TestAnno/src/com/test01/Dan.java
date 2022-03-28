package com.test01;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Dan {
	String value();
}

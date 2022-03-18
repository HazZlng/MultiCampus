package com.test03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/com/test03/a.properties")
public class AppConfig {
	
	@Bean(name="school")
	@DependsOn("student")
	public School getSchool() {
		School sm = new School();
		sm.setGrade(3);
		return sm;
	}
	
	@Bean(name="student")
	public Student getStudent() {
		Student s = new Student();
		return s;
	}
}

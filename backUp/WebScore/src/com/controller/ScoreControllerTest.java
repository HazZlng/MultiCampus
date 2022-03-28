package com.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import junit.framework.TestCase;
//https://docs.spring.io/spring-framework/docs/5.3.16/reference/html/testing.html#testing
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
		"file:C:\\Users\\User\\Desktop\\MultiCampus\\MultiCampus\\NewMyWeb\\WebScore\\WebContent\\WEB-INF\\applicationContext.xml",
		"file:C:\\Users\\User\\Desktop\\MultiCampus\\MultiCampus\\NewMyWeb\\WebScore\\WebContent\\WEB-INF\\score-servlet.xml" })
public class ScoreControllerTest {
   // 1. Context가 제대로 설정되었는지 확인 해 보자.
	 @Autowired
	 private WebApplicationContext  ctx;
	 
	 //2 . url 확인을 해보자. 
	 private MockMvc  mockMvc; // url확인, 동적페이지 확인등
	 
	 
	 //3.  dataSource가 제대로 연결되었는지 확인 해보자.  
	 @Autowired
	 private DataSource dataSource;
	 
	 @Before  
	 public void setup() {
		 //1번실행  테스트
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	 }
	 
	 @Test
	 public void Mylist() {
		 //2)번실행 테스트
		  try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/score/list.do"));
		} catch (Exception e) {			
			fail(e.getMessage());
			
		}		 
	 } 	
	 @Test
	 public void Myupdate() {
		 //2)번실행 테스트
		  try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/score/list.do"));
		} catch (Exception e) {			
			fail(e.getMessage());
			
		}		 
	 } 	
	 
	 @Test
	 public void Mydelete() {
		 //2)번실행 테스트
		  try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/score/list.do"));
		} catch (Exception e) {			
			fail(e.getMessage());
			
		}		 
	 } 	
	 
	 
	 @Test
	 public void Myfind() {
		 //2)번실행 테스트
		  try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/score/list.do"));
		} catch (Exception e) {			
			fail(e.getMessage());
			
		}		 
	 } 
	 @Test
	 public void MyTest02() {
		 //3번 실행 테스트 
		 assertNotNull(dataSource);		 
		 try(Connection con = dataSource.getConnection()){
			 assertNotNull(dataSource); 
		 }catch(Exception e) {
			 fail(e.getMessage());
		 }		 
	 } 
}























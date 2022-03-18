<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<html>
<head>
  <title>파일과 디렉토리  리스트</title>
</head>
<body>
<%! String path; %>
<% path = application.getRealPath("/upload/");
String[] listing =new File(path).list();				
		for(int i=0;i<listing.length;++i){
			out.println("list ["+i+"] :<a href="
		            +listing[i]+"> " +listing[i]+"</a> <br>");
		}
	out.println("<hr> 웹어플리케이션 프로젝트명 ="+request.getContextPath() +"<br><hr>");
	out.println("서블릿 절대경로 ="+	request.getServletPath()+"<br><hr>"); 
	out.println("실제 작업 어플리케이션의 루트 경로 ="+application.getRealPath("/") +"<br><hr>");
      
%>
</body>
</html>
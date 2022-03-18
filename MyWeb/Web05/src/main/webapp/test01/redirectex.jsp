<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>redirectex</title>
</head>
<body>
지금 페이지는 redirectex.jsp 페이지입니다.
<% 
 response.sendRedirect("errorChoice.html");   
%>
</body>
</html>
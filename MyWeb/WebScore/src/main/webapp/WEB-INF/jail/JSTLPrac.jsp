<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>PRAC</title>
</head>
<body>
	<c:out value = "hello"/><br>
	<c:set var = "aa" value = "world"/>
	${aa }<br>
	
	<c:forEach var="item" items="${list}" varStatus="vs" begin=0 end=5 step=1>
    <c:out value="${item.id}"/>
    <c:out value="${item.name}"/>
    <c:out value="${item.age}"/>
    <c:out value="${vs.index}"/>
	</c:forEach>
</body>
</html>
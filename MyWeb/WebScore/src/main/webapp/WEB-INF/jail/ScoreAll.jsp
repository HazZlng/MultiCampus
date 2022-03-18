<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%		
ArrayList<Score> sm = (ArrayList<Score>) request.getAttribute("all");
	%> --%>
	<table border=1 width="90%">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총 점</th>
			<th>평균</th>
			<th>학점</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
<%-- 		<%
			for (Score res : sm) {
		%> --%>
		
		<c:forEach var="scoreVO" items="${all}">
		<tr>
			<td>${scoreVO.name}</td>
			<td>${scoreVO.kor}</td>
			<td>${scoreVO.eng}</td>
			<td>${scoreVO.mat}</td>
			<td>${scoreVO.tot}</td>
			<td>${scoreVO.avg}</td>
			<td>${scoreVO.grade}</td>
			
			<td><a href="ScoreFind?name=${scoreVO.name}"> 수정 </a></td>
			<td><a href="ScoreDelete?name=${scoreVO.name}"> 삭제 </a></td>
			<!-- ScoreFind 서블릿 파일에 View단의 입력을 받아서 전달한다. -->
<%-- 			<td><a href="ScoreFind?name=<%=res.getName()%>"> 수정 </a></td>
			<td><a href="ScoreDelete?name=<%=res.getName()%>"> 삭제 </a></td> --%>
			</tr>
			</c:forEach>
		
<%-- 		<%
			/* } */
		%> --%>
		<tr>
			<td align="center" colspan="9">
			<a href="ScoreInsert.html">입력
			</a></td>
		</tr>
	</table>
</body>
</html>














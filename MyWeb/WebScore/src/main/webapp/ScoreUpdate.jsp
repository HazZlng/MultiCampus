<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
input {
	font-size: x-large;
}
</style>
</head>
<body>
	<%--
	<%
	Score my_score = (Score) request.getAttribute("find");
	%>
	 --%>
	<c:set var = "myScore" value="${find }"/>
	<form action="ScoreUpdate">
		<table border=1 width="70%"
			style="height: 400px; border-style: solid; font-size: x-large;">
			<tr>
				<th>이름</th>
				<td>${myScore.name} 
				<input type="hidden" name="name" value="${myScore.name}" /></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="text" name="kor"
					value="${myScore.kor}"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="text" name="eng"
					value="${myScore.eng}"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="text" name="mat"
					value="${myScore.mat}"></td>
			</tr>
			<tr>
				<th>총 점</th>
				<td>${myScore.tot}</td>
			</tr>
			<tr>
				<th>평균</th>
				<td>${myScore.avg}</td>
			</tr>
			<tr>
				<th>학점</th>
				<td>${myScore.grade}</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="수정" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>






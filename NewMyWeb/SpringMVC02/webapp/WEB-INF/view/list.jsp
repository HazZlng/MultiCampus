<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<body style="font-size: 1.5em;">
		
		<table border = "1">
			<tr>
				<th> 이름 </th>
				<th> 나이 </th>
				<th> 취미 </th>
			</tr>
			<c:if test = "${!empty allList }">
				<c:forEach items="${allList }" var = "ob">
					<tr>
						<td> ${ob.name }</td>
						<td> ${ob.age }</td>
						<td> ${ob.hobby }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	<a href= "<%=application.getContextPath()%>/index.html"> </a>
	
		
</body>
</html>
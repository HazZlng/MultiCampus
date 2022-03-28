<%@ page language="java" contentType="text/plain; charset=EUC-KR" %>
<%
	if(request.getParameter("userid").equals("abcd") &&
			request.getParameter("userpwd").equals("1234")){
%>
		{
		"result" : "ok"
		}
<%	
}else{
%>
		{
		"result" : "fail"
		}
<%		
	}
%>
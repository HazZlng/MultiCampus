<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<title>BufferedReader를 이용한 파일 읽기</title>
</head>
<body>
	<%
	String Path = "/test02/ex.txt";
	%>
	실제 경로:
	<br>
	<%=application.getRealPath(Path)%>
	<br>
	<hr>
	<br>
	<%=Path%>의 내용은 아래와 같습니다.
	<br>
	<hr>
	<%
	BufferedReader br = null;
	char[] buff = new char[512];
	int len = -1;

	try {
		br = new BufferedReader(new InputStreamReader(
				                     application.getResourceAsStream(Path)));

		while ((len = br.read(buff)) != -1) {
			out.println(new String(buff, 0, len));
		}
	} catch (IOException ex) {
		out.println("예외 발생: " + ex.getMessage());
	} finally {
		if (br != null)
			try {
		br.close();
			} catch (IOException ex) {
			}
	}
	%>
</body>
</html>











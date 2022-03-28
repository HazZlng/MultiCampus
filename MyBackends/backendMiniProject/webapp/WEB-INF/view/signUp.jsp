<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form id="signFrm" name="signFrm" action="signUp.do">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="userId" name="userId" ></td>
					<td><input type="button" id="check" value="중복체크"></td>
				</tr>
				<tr>
					<td colspan=3 id="idCheck"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td colspan="2"><input id="passwd" name="passwd" type="password"></td>
				</tr>
				<tr>
					<td>패스워드 확인</td>
					<td colspan="2"><input id="passwdCheck" name="passwdCheck" type="password"></td>
				</tr>
				
				<tr>
					<td colspan="3"><input type="button" id="signUp" value="회원가입"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>

<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx = false;
		
		$('#signUp').click(function(){
			if($.trim($('#userId').val()) == ''){
				alert("아이디 입력.");
				$('#userId').focus();
				return;
			}else if($.trim($('#passwd').val()) == ''){
				alert("패스워드 입력.");
				$('#passwd').focus();
				return;
			}
			//패스워드 확인
			else if($('#passwd').val() != $('#passwdCheck').val()){
				alert('패스워드가 다릅니다.');
				$('#passwd').focus();
				return;
			}
			
			if(idx==false){
				alert("아이디 중복체크를 해주세요.");
				return;
			}else{
				$('#signFrm').submit();
			}
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/idCheck.do",
				type: "GET",
				data:{
					"userId":$('#userId').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#userId').val()) != '' ){
						idx=true;
						$('#userId').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}else{

						var html="<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
			

		});
		
	});
</script>
</html>
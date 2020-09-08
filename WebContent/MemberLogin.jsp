<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
	<script>
		function goLogin() {
			loginform.submit();
		}
		function goJoin() {
			location.href = "MemberJoin.jsp";
		}
	</script>
	<style>
	body{
	margin : 5px ;
	}
	form{
	padding-bottom : 5px;
	}
	button{
	padding-bottom: 5px;}
	</style>
	
</head>
<body>
	<h2>로그인</h2>
	<form action="memberlogin" method="post" name="loginform">
		<input type="text" name="mid" id="mid" placeholder="아이디입력"><br>
		<input type="password" name="mpassword" id="mpassword"placeholder="비밀번호입력">
	</form>
	<button onclick="goLogin()">로그인</button><br>
	<button onclick="goJoin()">회원가입</button>
</body>
</html>








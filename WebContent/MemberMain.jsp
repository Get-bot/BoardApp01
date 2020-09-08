<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function memberUpdate() {
			location.href="memberupdate";
		}
		function memberlogout() {
			location.href="memberlogout";
		}
	</script>
	<style>
	button{
	margin-bottom:10px;}
	</style>
</head>
<body>
	<h2>마이페이지</h2>
	
	${sessionScope.loginId} 님 환영합니다. <br>
	작성한 글개수 : ${bcount}개 입니다.<br>
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="memberlist">관리자모드(회원목록)</a><br>
	</c:if>
	<br>
	
	<button onclick="memberUpdate()">회원정보수정</button><br>
	
	<button onclick="memberlogout()">로그아웃</button><br>
</body>
</html>




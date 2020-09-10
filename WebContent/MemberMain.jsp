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
			location.href="memberupdate?page=${page}";
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
	내가작성한 글목록 <br>
		<table border="1">
	<tr>
		<th>글번호</th> <th>작성자</th> <th>제목</th>
		<th>작성일자</th> <th>조회수</th></tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
			<td>${board.bnumber}</td>
			<td>${board.bwriter}</td>
			<td><a href="boardview?bnumber=${board.bnumber}&page=${page}">${board.btitle}</a></td>
			<td>${board.bdate}</td>
			<td>${board.bhits}</td>
			</tr>
		</c:forEach>
		</table>
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="memberlist">관리자모드(회원목록)</a><br>
	</c:if>
	<br>
	
	<button onclick="memberUpdate()">회원정보수정</button><br>
	
	<button onclick="memberlogout()">로그아웃</button><br>
</body>
</html>




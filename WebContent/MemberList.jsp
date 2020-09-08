<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function memberdelete(deleteid) {
		console.log(deleteid);
		location.href="memberdelete?mid="+deleteid;
	}
	function memberview(id) {
		location.href="memberview?mid="+id;
	}
</script>
</head>
<body>
	<h2>회원목록</h2>
	<table border="1">
	<tr>
		<th>아이디</th><th>조회</th><th>삭제</th></tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
			<td>${member.mid}</td>
			<td><button onclick="memberview('${member.mid}')">상세조회</button></td>
			<td><button onclick="memberdelete('${member.mid}')">삭제</button></td>
			</tr><br>
		</c:forEach>
	</table>
</body>
</html>








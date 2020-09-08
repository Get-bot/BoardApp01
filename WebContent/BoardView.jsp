<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>BoardView.jsp</h2>
	<table border="1">
	<tr>
		<td>제목</td>
		<td>${boardView.btitle}</td></tr>
	<tr>
		<td>작성자</td>
		<td>${boardView.bwriter}</td></tr>		
	<tr>
		<td>내용</td>
		<td>${boardView.bcontents}</td></tr>
	<tr>
		<td>조회수</td>
		<td>${boardView.bhits}</td></tr>
	<tr>
		<td>파일명</td>
		<td>${boardView.bfilename}</td></tr>
	<tr>
		<td>파일이미지</td>
		<td><img src="UploadFile/${boardView.bfilename}" width="200" height="200"></td></tr>
	</table>	
	<c:if test ="${sessionScope.loginId eq boardView.bwriter}">
	<button onclick="location.href=
				'boardupdate?bnumber=${boardView.bnumber}&page=${page}'">수정</button>
	</c:if>	
	<c:if test ="${sessionScope.loginId eq 'admin'|| sessionScope.loginId eq boardView.bwriter}">
	<button onclick="location.href=
				'boarddelete?bnumber=${boardView.bnumber}'">삭제</button>	
	</c:if>						
	<!-- 페이징 목록 보는 버튼 추가 
		BoardViewController에서 가져온 page값을 가지고 가야함. 그래야 보고있던 페이지가 그대로 출력될 수 있음 -->
	<button onclick="location.href='boardlistpaging?page=${page}'">목록</button>
	
	
</body>
</html>










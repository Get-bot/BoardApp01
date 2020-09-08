<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardUpdate() {
		updateform.submit();
	}
</script>
</head>
<body>
	<h2>BoardUpdate.jsp</h2>
	<form action="boardupdateprocess" method="post" name="updateform">
		글번호 : <input type="text" name="bnumber" id="bnumber" value="${boardUpdate.bnumber}" readonly><br>
		<input type="hidden" name="bnumber" value="${boardUpdate.bnumber}">
		작성자 : <input type="text" name="bwriter" id="bwriter" value="${boardUpdate.bwriter}"><br>
		제목 : <input type="text" name="btitle" id="btitle" value="${boardUpdate.btitle}"><br>
		내용 : <textarea cols="30" rows="10" name="bcontents" id="bcontents">
				${boardUpdate.bcontents}</textarea><br>
				<input type="text" name="page" id="page" value="${page}" readonly>
	</form>
	<button onclick="boardUpdate()">수정</button>
	 
	
	
	
	
</body>
</html>
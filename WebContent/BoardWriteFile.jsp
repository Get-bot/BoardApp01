<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardWriteFile() {
		writeform.submit();
	}
	function boardList() {
		location.href='boardlistpaging';
	}
</script>
</head>
<body>
	<h2>BoardWriteFile.jsp</h2>
	<form action="boardwritefile" method="post" name="writeform"
			enctype="multipart/form-data">
		작성자 : <input type="text" name="bwriter" id="bwriter" value="${sessionScope.loginId}" readonly><br>
		제목 : <input type="text" name="btitle" id="btitle"><br>
		내용 : <textarea name="bcontents" id="bcontents" cols="30" rows="10"></textarea>
		<br>
		첨부파일 : <input type="file" name="bfile" id="bfile">
	</form>
	<button onclick="boardWriteFile()">글작성(파일)</button>
	<button onclick="boardList()">글목록</button>
</body>
</html>

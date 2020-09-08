<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원상세정보</h2>
	아이디 : ${memberView.mid} <br>
	이름 : ${memberView.mname} <br>
	전화번호 : ${memberView.mphone} <br>
	이메일 : ${memberView.memail} <br>
	성별 : ${memberView.mgender} <br>
	프로필사진 :<br>
	<img src="ImgFile/${memberView.imgfile}" width="200" height="200">
</body>
</html>









<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script>
	function memberUpdateProcess() {
		var pw = document.getElementById("mpassword").value;
		var pwdb = '${memberUpdate.mpassword}';
		console.log(pw);
		console.log(pwdb);
		if(pw.length != 0){
			if(pw==pwdb){
				updateform.submit();
			} else {
				alert('비밀번호가 틀립니다');
			}
		} else {
			alert('비밀번호를 입력해주세요');
		}
	}
</script>
</head>
<body>
	<h2>회원정보수정</h2>
	<form action="memberupdateprocess" method="post" name="updateform">
		아이디 : <input type="text" name="mid" id="mid" value="${memberUpdate.mid}" readonly><br>
		이름 : <input type="text" name="mname" id="mname" value="${memberUpdate.mname}"><br>
		전화번호 : <input type="text" name="mphone" id="mphone" value="${memberUpdate.mphone}"><br>
		이메일 : <input type="text" name="memail" id="memail" value="${memberUpdate.memail}"><br>
		비밀번호확인 : <input type="password" name="mpassword" id="mpassword"><br>
		<input type="hidden" name="page" id="page" value="${page}">
	</form>
	<button onclick="memberUpdateProcess()">정보수정</button>



</body>
</html>
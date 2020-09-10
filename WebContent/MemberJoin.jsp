<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    } 0
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
    
    function chkPW(){

    	 var pw = $("#mpassword").val();
    	 var num = pw.search(/[0-9]/g);
    	 var eng = pw.search(/[a-z]/ig);
    	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    	 if(pw.length < 8 || pw.length > 20){

    	  alert("8자리 ~ 20자리 이내로 입력해주세요.");
    	  return false;
    	 }else if(pw.search(/\s/) != -1){
    	  alert("비밀번호는 공백 없이 입력해주세요.");
    	  return false;
    	 }else if(num < 0 || eng < 0 || spe < 0 ){
    	  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
    	  return false;
    	 }else {
    		 alert("통과"); 
    	    return true;
    	 }
    }
    
    function chkID(){

   	 var id = $("#mid").val();
   	 var num = id.search(/[0-9]/g);
   	 var eng = id.search(/[a-z]/ig);

   	 if(id.length < 5 || id.length > 12){

   	  alert("5자리 ~ 12자리 이내로 입력해주세요.");
   	  return false;
   	 }else if(id.search(/\s/) != -1){
   	  alert("아이디는 공백 없이 입력해주세요.");
   	  return false;
   	 }else if(num < 0 || eng < 0){
   	  alert("영문,숫자를 혼합하여 입력해주세요.");
   	  return false;
   	 }else {
   		alert("통과"); 
   	    return true;
   	 }

   	}
    function join(){
    	imgform.submit();
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
	padding-bottom: 5px;
	margin-bottom: 5px;}
	</style>
	
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="imgjoin" method="post" name="imgform"
	enctype="multipart/form-data">
		<input type="text" name="mid" id="mid" placeholder="아이디">
		<button type="button" onclick ="chkID()" >아이디확인</button><br>
		<input type="password" name="mpassword" id="mpassword" placeholder="비밀번호">
		<button type="button" onclick ="chkPW()">비밀번호확인</button><br>
		<input type="text" name="mname" id="mname" placeholder="이름"><br>
		<input type="date" name="mbirth" id="mbirth" placeholder="생년월일"><br>
		<input type="text" name="mphone" id="mphone" placeholder="전화번호"><br>
		<input type="text" name="memail" id="memail" placeholder="이메일"><br>
		<input type="text" name="postcode" id="postcode" placeholder="우편번호">
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" name="address" id="address" placeholder="주소"><br>
		<input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소">
		<input type="text" name="extraAddress" id="extraAddress" placeholder="참고항목"><br>
		성별 : <input type="radio" name="mgender" value="남자">남
				<input type="radio" name="mgender" value="여자">여<br>	
		프로필사진: <input type="file" name="mfile" id="mfile"><br>
	</form>
		<button onclick="join()">회원가입</button><br>
</body>
</html>







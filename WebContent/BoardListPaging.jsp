<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  function searchCheck(form){

        if(form.keyword.value ==""){
            alert("검색 단어를 입력하세요.");
            form.keyword.focus();
            return;
        }
        serach.submit();      
    }
  </script>
</head>
<body>
	<h2>BoardListPaging.jsp</h2>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="board" items="${boardList}" >
			<tr>
				<td>${board.bnumber}</td>
				<td><a
					href="memberview?mid=${board.bwriter}&page=${paging.page}">${board.bwriter}</a></td>
				
				<td><a
					href="boardview?bnumber=${board.bnumber}&page=${paging.page}">${board.btitle}</a></td>
				<td>${board.bdate}</td>
				<td>${board.bhits}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><button onclick="location.href='BoardWriteFile.jsp'">글쓰기</button>
			<button onclick="location.href=
				'mypage?mid=${sessionScope.loginId}'">마이페이지</button> 
			<button onclick="location.href=
				'boardserch?keyfield=hits'">조회수정렬</button></td>

		</tr>
		
	</table>
	

	<!-- 페이징 처리 -->
	<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	
	<c:if test="${paging.page>1}">
		<a href="boardlistpaging?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
			</c:when>
			<c:otherwise>
				<a href="boardlistpaging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>
	
	<c:if test="${paging.page<paging.maxPage}">
		<a href="boardlistpaging?page=${paging.page+1}">[다음]</a>
	</c:if>
<table>
     <tr>  
        <td colspan="7"> <br/>
            <form action="boardserch" name="serach" method ="get">
            <select name="keyfield">
                <option value="0"> ----선택----</option>
                <option value="id">아이디</option>
                <option value="title">제목</option>  
            </select>
            <input type="text" name="keyword"/>
            <input type="button" value="검색" onclick="searchCheck(form)" />     
            </form>
           
        </td>      
    </tr>
    </table>

</body>
</html>
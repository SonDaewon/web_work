<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/detail.jsp</title>
<style>
	.content{
		width: 766px;
		border: 1px solid #888888;
		box-shadow: 10px 10px 5px #888888;
	}
	.content img{
		max-width: 100%;
	}
</style>
</head>
<body>
<div>
	<c:if test="${dto.prevNum ne 0}">
		<a href="detail.do?num=${dto.prevNum }">이전글</a> |
	</c:if>
	<c:if test="${dto.nextNum ne 0}">
		<a href="detail.do?num=${dto.nextNum }">다음글</a>
	</c:if>
</div>
<h3>글 자세히 보기 페이지</h3>
<c:if test="${sessionScope.id eq dto.writer }">
	<a href="private/updateform.do?num=${dto.num }">수정</a>
	<a href="javascript:deleteConfirm()">삭제</a>
	<script>
		function deleteConfirm(){
			var isDelete=confirm("글을 삭제 하시겠습니까?");
			if(isDelete){
				location.href="private/delete.do?num=${dto.num}";
			}
		}
	</script>
</c:if>
<table>
	<tr>
		<th>글번호</th>
		<td>${dto.num }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${dto.title }</td>
	</tr>
</table>
<div class="content">${dto.content }</div>
<a href="list.do">목록 보기</a>
</body>
</html>







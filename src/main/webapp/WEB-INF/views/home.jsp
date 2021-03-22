<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<script>
function goBoardDetail(idx){                
    location.href = "/view?idx="+ idx;
}
</script>

<body>
<nav class="navbar navbar-expand-sm bg-light"> 
<!-- 리스트 : 부트스트랩은 모바일 우선이라 화면이 작으면 아래로 쌓아서 내려온다 --> 
	<ul class="navbar-nav">
		<li class="nav-item">
  			<a class="nav-link" href="/home">게시글 목록</a> 
  		</li>
  		<li class="nav-item">
   			<a class="nav-link" href="/logout">로그아웃</a>
    	</li>
    	<li class="nav-item">
   			<a class="nav-link" href="/mypage">마이페이지</a>
    	</li>
    </ul>
</nav>



<div class="container" align="center">
	<h1 a>게시글 목록</h1>
	<div class="container" align="left" style="margin-bottom: 10px;">
		<button name = "write" class="btn btn-sm btn-primary btn-block" onclick="location.href='/writeform'" style="width: 20%" >글작성하기</button>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${viewAll}" var="viewAll">
				<tr onclick='javascript:goBoardDetail("${viewAll.idx}");'>				      
					<td>${viewAll.idx}</td>
					<td>${viewAll.title}</td>
					<td>${viewAll.content}</td>
					<td>${viewAll.writer}</td>
					<td><fmt:formatDate value="${viewAll.regDate}" pattern="yyyy.MM.dd"/></td>
					<td>${viewAll.viewCnt}</td>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<div style="display: block; text-align: center;">
	<ul class="pagination justify-content-center pagination-sm">	
		<c:if test="${paging.startPage != 1 }">
			<li class="page-item"><a href="/home?nowPage=${paging.startPage - 2 }&cntPerPage=${paging.cntPerPage}" class="page-link">&lt;</a></li>
		</c:if>
		<!-- 
		<c:if test="${paging.nowPage < paging.startPage - 2}">			
			<li class="page-item"><a href="/home?nowPage=${paging.startPage -3 }&cntPerPage=${paging.cntPerPage}" class="page-link">이전</a></li>
		</c:if>
		-->
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<li class="page-item active"><a href="#" class="page-link"><b>${p }</b></a></li>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<li class="page-item"><a href="/home?nowPage=${p}&cntPerPage=${paging.cntPerPage}" class="page-link">${p }</a></li>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.startPage +5 < paging.lastPage}">			
			<li class="page-item"><a href="/home?nowPage=${paging.startPage +5 }&cntPerPage=${paging.cntPerPage}" class="page-link">다음</a></li>
		</c:if>
		<c:if test="${paging.endPage != paging.lastPage}">			
			<li class="page-item"><a href="/home?nowPage=${paging.endPage+2 }&cntPerPage=${paging.cntPerPage}" class="page-link">&gt;</a></li>
		</c:if>
	</ul>
	</div>


</body>
</html>

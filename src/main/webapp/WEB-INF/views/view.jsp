<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>게시글 보기</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = session.getAttribute("id").toString();
%>
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
<div class="container">
	<h2>게시글 조회</h2>

	<table class="table">
				<tr>
					<td>제목</td><td>${view.title}</td>
				</tr>
				<tr>
					<td>작성자</td><td>${view.writer}</td>
				</tr>
				<tr>
					<td>작성일자</td><td><fmt:formatDate value="${view.regDate}" pattern="yyyy.MM.dd"/></td>
				</tr>
				<tr>
					<td>본문</td><td>${view.content}</td>
				</tr>
				
		
	</table>
		<c:if test="${id eq view.writer}">
			<button name = "delete" class="btn btn-sm btn-primary btn-block" onclick="location.href='/delete?idx=${view.idx}'"  style="width: 30%; display: inline;">삭제하기</button>
			<button name = "modify" class="btn btn-sm btn-primary btn-block" onclick="location.href='/modifyform?idx=${view.idx}'"  style="width: 30%;  display: inline; margin-top: 0; ">수정하기</button>
		</c:if>
		
	

</div>
</body>
</html>





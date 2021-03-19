<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>게시글 보기</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<body>
<div class="container">
	<h1>게시글 조회</h1>

	<table class="table">
				<tr>
					<td>제목</td><td>${view.title}</td>
				</tr>
				<tr>
					<td>작성자</td><td>${view.writer}</td>
				</tr>
				<tr>
					<td>작성일자</td><td>${view.regDate}</td>
				</tr>
				<tr>
					<td>본문</td><td>${view.content}</td>
				</tr>
				
		
	</table>
		<button name = "delete" class="btn btn-lg btn-primary btn-block" onclick="location.href='/delete?idx=${view.idx}'"  style="width: 30%; display: inline;">삭제하기</button>
		<button name = "modify" class="btn btn-lg btn-primary btn-block" onclick="location.href='/modifyform?idx=${view.idx}'"  style="width: 30%;  display: inline; margin-top: 0; ">수정하기</button>
	

</div>
</body>
</html>





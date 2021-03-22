<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
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
<div class="container" align="center" style="width: 80%">
<form name="user_delete" class="form">
	<h2>회원탈퇴</h2>
	<h4>정말 탈퇴하시겠습니까?</h4>
	<label for="inputEmail" class="sr-only"></label>
	<input type="password" name="password" class="form-control" style="width: 60%" placeholder="비밀번호를 입력해주세요"></td>

	<button type="submit" name="cancle" formaction="/mypage" formmethod="post" class="btn btn-sm btn-primary btn-block" style="width: 30%; display: inline;">취소하기</button>
	<button type="submit" name="user_delete" formaction="/user_delete" formmethod="post" class="btn btn-sm btn-primary btn-block" style="width: 30%;  display: inline; margin-top: 0; ">탈퇴하기</button>
</form>
</div>
</body>



</html>
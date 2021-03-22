<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script>
function validate() {
	var id = document.getElementById("id");
	var password = document.getElementById("password");
	
	if(id.value != ""){
		if(password.value != ""){
			return true;
		}
		else{
			alert("비밀번호를 입력해주세요");
			password.focus();
			return false;
		}
	}
	else{
		alert("아이디를 입력해주세요");
		id.focus();
		return false;
	}
		
}
</script>

<body>


	<div class="container">

      <form class="form-signin" method="post" action="/join" onsubmit="return validate()">
        <h2 class="form-signin-heading">회원가입</h2>
        <label for="inputEmail" class="sr-only">이메일</label>
        <input type="email" id="id" name="id" class="form-control" placeholder="Email address"  required autofocus>
        <label for="inputPassword" class="sr-only">비밀번호</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-sm btn-primary btn-block" type="submit">가입하기</button>
        </div>
        
      </form>

    </div> <!-- /container -->
</body>
</html>
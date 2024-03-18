<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body {
	min-height: 100vh;
	background-color: #fff; /* 백그라운드 색상을 흰색으로 설정 */
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	border-radius: 10px;
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
}

.form-control, .btn {
	width: 100%; /* 입력 폼과 버튼의 폭을 같게 설정 */
}

.btn-submit {
	margin-top: 20px;
}
</style>
</head>

<body>
	<div class="container">
        <div class="input-form-backgroud row">
            <div class="input-form col-md-6 mx-auto">
                <h4 class="mb-3">관리자 로그인</h4>
                <form class="login" action="/admin/login" method="POST">
                    <!-- 이메일 입력란 -->
                    <div class="form-group row">
                        <label for="email" class="col-md-3 col-form-label">이메일</label>
                        <div class="col-md-9">
                            <input type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요." value="" name="userEmail" required>
                        </div>
                    </div>
                    <!-- 비밀번호 입력란 -->
                    <div class="form-group row">
                        <label for="password" class="col-md-3 col-form-label">비밀번호</label>
                        <div class="col-md-9">
                            <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력해주세요." value="" name="userPassword" required>
                        </div>
                    </div>
                    <!-- 로그인 버튼 -->
                    <div class="form-group row">
                        <div class="col-md-12">
                            <button class="btn btn-primary btn-lg btn-block btn-submit" type="submit">로그인</button>
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <div class="col-md-6">
                            <a href="/findUsername">아이디 찾기</a>
                        </div>
                        <div class="col-md-6">
                            <a href="/findPassword">비밀번호 찾기</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <footer class="my-3 text-center text-small">
            <p class="mb-1">&copy; 2024 by ggolddoogi</p>
        </footer>
    </div>
    
    
</body>

</html>

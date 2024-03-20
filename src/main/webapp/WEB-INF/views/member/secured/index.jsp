<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! 우리끼리만 맛난거 먹자!!
</h1>
<P>  The time on the server is ${serverTime}. </P>
<a href="/admin/login">관리자</a>
<a href="/member/register">회원가입</a>
<a href="/member/login">로그인</a>
</body>
</html>
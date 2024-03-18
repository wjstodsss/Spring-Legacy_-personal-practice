<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<a href="/logout">로그아웃</a>
<!-- 필터 적용을 위해 /admin/secured포함 경로 생성-->
<a href="/admin/secured/user_list">회원 관리 페이지</a>
</body>
</html>
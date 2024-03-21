<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Upload Success</title>
</head>
<body>
    <h2>File Upload Success</h2>
    <c:forEach var="fileName" items="${fileNames}">
    	<p>Uploaded File: ${fileName}</p>
    	<img src="upload/${fileName}" alt="Uploaded Image">
    </c:forEach>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
    src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
    src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1>회원 상세 정보</h1>

    <div class="container">
        <form id="updateForm" action="/admin/update" method="post">
            <input type="hidden" class="form-control mb-2 mr-sm-2" id="id" value="${user.id}" name="id">
            <label for="userName" class="mb-2 mr-sm-2">Name</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="userName" value="${user.userName}" name="userName">
                
            <label for="userEmail" class="mb-2 mr-sm-2">Email</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="userEmail" value="${user.userEmail}" name="userEmail" readonly>
        
            <label for="userPassword" class="mb-2 mr-sm-2">Password</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="userPassword" value="${user.userPassword}" name="userPassword" readonly>

        
            <label for="userInfo" class="mb-2 mr-sm-2">Message</label>
            <textarea class="form-control mb-2 mr-sm-2" id="userInfo" name="userInfo" rows="10" cols="50" maxlength="1000">${user.userInfo}</textarea>
            <button type="button" class="btn btn-primary mb-2" onclick="updateData()">Update</button>
            <button type="button" class="btn btn-info mb-2" onclick="window.location.href='user_list'">List</button>
        </form>
            
    </div>

</body>

<script>
    function updateData() {
        document.getElementById("updateForm").submit();
    }
</script>
</html>

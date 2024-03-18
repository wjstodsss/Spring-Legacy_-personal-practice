<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>회원 정보</h2>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>email</th>
					<th>password</th>
					<th>userInfo</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="users" items="${users}">
					<tr>
						<td><a href="/admin/secured/detail?id=${users.id}">${users.id}</a></td>
						<td>${users.userName}</td>
						<td>${users.userEmail}</td>
						<td>${users.userPassword}</td>
						<td>${users.userInfo}</td>
						<td>
							<button type="button" class="btn btn-danger mb-2"
								onclick="deleteData('${users.id}')">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

<script>
	function deleteData(id) {
	    console.log("Delete ID:", id);
	    if (confirm("삭제할까요?")) {
	        // AJAX를 사용하여 삭제 요청을 보냄

	        $.ajax({
	            type: "POST",
	            url: "/admin/delete",
	            data: { id: id },
	            success: function(response) {
	                // 삭제 성공 시 페이지를 다시 로드
	                location.reload(); // 현재 페이지를 새로 고침
	            },
	            error: function(xhr, status, error) {
	                console.error("Delete failed:", error);
	                // 삭제 실패 시 사용자에게 알림 등을 추가할 수 있습니다.
	            }
	        });
	    }
	}
</script>
</html>

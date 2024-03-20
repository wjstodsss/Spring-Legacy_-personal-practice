<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 정보 관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2>재고 관리 페이지</h2>
   
    <table class="table">
    <!-- 상품 등록 버튼 -->
    <a href="/admin/inventory_add" class="btn btn-success mb-3">상품 등록</a>
        <thead>
            <tr>
                <th>상품 ID</th>
                <th>상품명</th>
                <th>재고량</th>
                <th>판매량</th>
                <th>발주량</th>
                <th>비고</th>
                <th>작업</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="inventory" items="${inventories}">
                <tr>
                    <td>${inventory.id}</td>
                    <td>${inventory.productName}</td>
                    <td>${inventory.stockQuantity}</td>
                    <td>${inventory.salesQuantity}</td>
                    <td>${inventory.orderedQuantity}</td>
                    <td>${inventory.remarks}</td>
                    <td>
                        <a href="/admin/secured/inventory_detail?id=${inventory.id}" class="btn btn-primary">상세 보기</a>
                        <button type="button" class="btn btn-danger" onclick="deleteInventory(${inventory.id})">삭제</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script>
    function deleteInventory(id) {
        console.log("Delete Inventory ID:", id);
        if (confirm("정말로 이 상품을 삭제하시겠습니까?")) {
            // AJAX를 사용하여 삭제 요청을 보냄
            $.ajax({
                type: "POST",
                url: "/admin/inventory_delete",
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
</body>
</html>

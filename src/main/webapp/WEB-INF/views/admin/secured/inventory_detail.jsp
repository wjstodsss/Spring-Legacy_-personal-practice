<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    <h1>제품 재고 정보</h1>

    <div class="container">
        <form id="updateForm" action="/admin/inventory_update" method="post">
            <input type="hidden" class="form-control mb-2 mr-sm-2" id="id" value="${inventory.id}" name="id">
            <label for=inventoryPproductName" class="mb-2 mr-sm-2">품명</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="inventoryName" value="${inventory.productName}" name="productName">

            <label for="inventoryStockQuantity" class="mb-2 mr-sm-2">재고량</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="inventoryStockQuantity" value="${inventory.stockQuantity}" name="stockQuantity">
            
            <label for="inventorySalesQuantity" class="mb-2 mr-sm-2">판매량</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="inventorySalesQuantity" value="${inventory.salesQuantity}" name="salesQuantity">
            
            <label for="inventoryOrderedQuantity" class="mb-2 mr-sm-2">발주량</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="inventoryOrderedQuantity" value="${inventory.orderedQuantity}" name="orderedQuantity">

			<label for="inventoryRemarks" class="mb-2 mr-sm-2">비 고</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="inventoryRemarks" value="${inventory.remarks}" name="remarks">
            
            <button type="submit" class="btn btn-primary mb-2" >Update</button>
            <button type="button" class="btn btn-info mb-2" onclick="window.location.href='inventory_list'">List</button>
        </form>
            
    </div>

</body>


</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>쇼핑몰</title>
<!-- 부트스트랩 CSS 링크 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- 커스텀 CSS -->
<link rel="stylesheet" href="styles.css">
<style>
    /* 헤더 스타일 */
    header {
        background-color: #343a40;
    }
    .header-links {
        display: flex;
        gap: 10px;
    }
    .header-links a {
        color: white;
    }
</style>
</head>
<body>
    <!-- 헤더 영역 -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">쇼핑몰</a>
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <!-- 카테고리 메뉴 -->
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="#">의류</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">신발</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">악세서리</a></li>
                </ul>
            </div>
            <div class="header-links ml-auto">
                
                <a href="/member/login">로그인</a>
                <a href="/member/register">회원가입</a>
                <a href="/member/cart">장바구니</a>
                <a href="/admin/login">관리자</a>
            </div>
            <div class="mr-auto ml-3">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="상품 검색" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                </form>
            </div>
        </nav>
        
    </header>

    <div class="container mt-3">
        <!-- 서버에서 받아온 상품 목록 -->
        <div class="row">
            <%-- 예시로 3개의 상품을 받아와서 표시 --%>
            <% for (int i = 1; i <= 3; i++) { %>
            <div class="col-md-4 mb-3">
                <div class="card">
                    <img src="product<%= i %>.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">
                            상품
                            <%= i %></h5>
                        <p class="card-text">상품 설명이 여기에 들어갑니다.</p>
                        <!-- 장바구니에 담는 버튼 -->
                        <a href="#" class="btn btn-primary">장바구니에 추가</a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>

    <!-- 푸터 영역 -->
    <footer class="bg-dark text-white mt-5 py-3">
        <div class="container text-center">
            <p>&copy; 2024 쇼핑몰. All Rights Reserved.</p>
        </div>
    </footer>

    <!-- 부트스트랩 JS와 jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

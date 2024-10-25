<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!doctype html>
<%@ include file="common/tags.jsp" %>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<%@ include file="common/common.jsp" %>
<title>샘플 애플리케이션</title>
</head>
<body>
<!-- 헤더부 -->
<header>
	<c:set var="menu" value="home"/>
	<%@ include file="common/nav.jsp" %>
</header>
<!-- 메인 컨텐츠부 -->
<main>
	<div class="container my-3">
	   <div class="p-5 mb-4 bg-dark rounded-3 text-white">
	      <div class="container-fluid py-3">
	         <h1 class="display-5 fw-bold">샘플 애플리케이션</h1>
	         <p class="col-10 fs-4">회원가입, 로그인, 로그아웃, 상품목록 조회, 상품상세정보 조회, 상품 리뷰쓰기, 장바구니 담기, 구매하기 연습용 샘플 애플리케이션 입니다.</p>
	         <a class="btn btn-primary btn-lg" href="login">로그인</a>
	      </div>
	   </div>
	</div>
</main>
<!-- 푸터부 -->
<footer>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

</script>
</body>
</html>
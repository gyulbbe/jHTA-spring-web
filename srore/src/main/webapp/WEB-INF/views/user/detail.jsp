<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../common/common.jsp" %>
<title>샘플 애플리케이션</title>
</head>
<body>
<!-- 헤더부 -->
<header>
	<c:set var="user" value="home"/>
	<%@ include file="../common/nav.jsp" %>
</header>

<!-- 메인 컨텐츠부 -->
<main>
	<div class="container my-3">
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-dark text-white fw-bold">사용자 상세정보</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="p-2 mb-1 bg-light rounded-3 text-dark">
					<p class="col-8"><span class="fs-1"></span>님의 현재 적립포인트는 
						<strong class="text-danger fs-2">1,000 </strong>점 입니다.</p>
				</div>
			</div>
		</div>
		
	</div>	
</main>

<!-- 푸터부 -->
<footer>

</footer>
</body>
</html>
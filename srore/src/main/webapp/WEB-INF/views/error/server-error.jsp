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
	<c:set var="menu" value="board"/>
	<%@ include file="../common/nav.jsp" %>
</header>

<!-- 메인 컨텐츠부 -->
<main>
	<div class="container my-3">
		<div class="row mb-3">
			<div class="col">
				<div class="row mb-3">
					<div class="col">
						<div class="border p-2 bg-dark text-white fw-bold">오류 정보</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="alert alert-danger" role="alert">
  					<h4 class="alert-heading">서버 오류</h4>
  					<p>서버에서 예상하지 못한 오류가 발생하였습니다.</p>
  					<hr>
  					<p class="mb-0">잠시 후 다시 시작해보시기 바랍니다.</p>
  					<p class="mb-0">오류가 개선되지 않으면 아래의 연락처로 연락바랍니다.</p>
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
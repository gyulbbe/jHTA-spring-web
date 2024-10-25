<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<div class="row mb-3">
			<div class="col">
				<div class="row mb-3">
					<div class="col">
						<div class="border p-2 bg-dark text-white fw-bold">로그인</div>
					</div>
				</div>
				
				<div class="row mb-3">
					<div class="col">
						<div class="border p-2 bg-light">
							<form id="form-login" method="post" action="login" novalidate="novalidate">
								<div class="mb-3">
									<label class="form-label">아이디</label>
									<input type="text" class="form-control" id="user-email" name="email" />
								</div>
								<div class="mb-3">
									<label class="form-label">비밀번호</label>
									<input type="password" class="form-control" id="user-password" name="pwd" />
								</div>
								<div class="mb-3 text-end">
									<button type="submit" class="btn btn-primary">로그인</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="row mb-1">
					<div class="col">
						<img src="resources/images/banners/item.png" class="img-thumbnail">
					</div>
				</div>
				<div class="row mb-1">
					<div class="col">
						<img src="resources/images/banners/item.png" class="img-thumbnail">
					</div>
				</div>
				<div class="row mb-1">
					<div class="col">
						<img src="resources/images/banners/item.png" class="img-thumbnail">
					</div>
				</div>
				<div class="row mb-1">
					<div class="col">
						<img src="resources/images/banners/item.png" class="img-thumbnail">
					</div>
				</div>
				<div class="row mb-1">
					<div class="col">
						<img src="resources/images/banners/item.png" class="img-thumbnail">
					</div>
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
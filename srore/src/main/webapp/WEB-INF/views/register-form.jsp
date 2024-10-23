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
<main class="">
	<div class="container my-3">
		<div class="row mb-3">
			<div class="col">
				<div class="row mb-3">
					<div class="col">
						<div class="border p-2 bg-dark text-white fw-bold">회원가입</div>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col">
						<div class="border p-2 bg-light">
							<form:form id="form-register" 
									   method="post" 
									   action="register" 
									   modelAttribute="registerForm"
									   novalidate="novalidate">
								<div class="mb-3">
									<label class="form-label">이메일</label>
									<form:input class="form-control" id="user-email" path="email" />
									<form:errors path="email" cssClass="text-danger fst-italic"/>
								</div>
								<div class="mb-3">
									<label class="form-label">비밀번호</label>
									<form:password class="form-control" id="user-password" path="password" />
									<form:errors path="password" cssClass="text-danger fst-italic"/>
								</div>
								<div class="mb-3">
									<label class="form-label">비밀번호 확인</label>
									<form:password class="form-control" id="user-password-confirm" path="passwordConfirm" />
									<form:errors path="passwordConfirm" cssClass="text-danger fst-italic"/>
								</div>
								<div class="mb-3">
									<label class="form-label">닉네임</label>
									<form:input class="form-control" id="user-nick-name" path="nickname" />
									<form:errors path="nickname" cssClass="text-danger fst-italic"/>
								</div>
								<div class="mb-3">
									<label class="form-label">전화번호</label>
									<form:input class="form-control" id="user-tel" path="tel" />
									<form:errors path="tel" cssClass="text-danger fst-italic"/>
								</div>
								<%-- <div class="mb-3">
		                           <div class="form-check form-check-inline">
		                              <form:checkbox class="form-check-input" path="roles" value="ROLE_USER" checked />
		                              <label class="form-check-label">일반 사용자</label>
		                           </div>
		                           <div class="form-check form-check-inline">
		                              <form:checkbox class="form-check-input" path="roles" value="ROLE_MANAGER" />
		                              <label class="form-check-label">매니저</label>
		                           </div>
		                        </div> --%>
								<div class="mb-3 text-end">
									<a class="btn btn-secondary" href="/">취소</a>
									<form:button type="submit" class="btn btn-primary">회원가입</form:button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header bg-dark text-white">광고</div>
					<div class="card-body">
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
		</div>
	</div>	
</main>

<!-- 푸터부 -->
<footer>

</footer>
</body>
</html>
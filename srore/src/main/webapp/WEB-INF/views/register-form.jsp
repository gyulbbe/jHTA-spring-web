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
									<div class="d-flex justify-content-between">
										<form:input class="form-control" id="user-email" path="email" onchange="rollbackEmailCheck()" />
										<button type="button" class="btn btn-outline-primary btn-sm" onclick="checkEmail()">중복체크</button>
									</div>
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
									<form:button type="button" class="btn btn-primary" onclick="formSubmit()">회원가입</form:button>
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
<script>
	let isEmailChecked = false;
	let isEmailPassed = false;
	
	// 중복체크 후에 이메일을 다시 변경했을 때 체크여부, 통과여부를 전부 되돌린다.
	function rollbackEmailCheck() {
		alert('롤백');
		isEmailChecked = false;
		isEmailPassed = false;
	}
	
	function formSubmit() {
		if (!isEmailChecked) {
			alert('이메일 중복체크를 수행하지 않았습니다.');
			return;
		}
		if (!isEmailPassed) {
			alert('이미 사용중인 이메일은 사용할 수 없습니다.');
			return;
		}
		
		// 비밀번호, 비밀번호확인, 닉네임, 전화번호 입력여부 체크하자.
		document.querySelector("#form-register").submit();
	}
	
	/*
		fetch메소드를 비동기 방식으로 실행시킨다.
		await 키워드는 요청처리가 완료될 때까지 기다린다.
		await 키워드를 사용할 경우 해당함수에는 async 키워드를 붙여서 함수내부에서 비동기 통신을 수행하고 있음을 나타낸다.
		let response = await fetch(요청URL);
		let data = await response.text();
	 */
	async function checkEmail(){
		// 입력필드 획득
		let input = document.querySelector('#user-email');
		// 입력필드에 입력한 이메일 획득
		let email = input.value;
		if (email === "") {
			alert("이메일을 입력하세요.");
			input.focus();
			return;
		}
		
		isEmailChecked = true;
		let response = await fetch("/check-email?email=" + email);
		if (response.ok) {
			let data = await response.text();
			if (data == 'none') {
				isEmailPassed = true;
				alert('사용가능한 이메일입니다.');
			} else if (data == 'exists') {
				isEmailPassed = false;
				alert('이미 사용중인 이메일입니다.');
			}
		}
		// 체크결과 화면에 표시
	}
</script>
</body>
</html>
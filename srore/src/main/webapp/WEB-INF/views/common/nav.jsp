<%@ page pageEncoding="UTF-8"%>
<%@ include file="tags.jsp" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="/home">샘플 쇼핑몰</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link ${menu eq 'home' ? 'active fw-bold' : '' }"  href="/home">홈</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${menu eq 'product' ? 'active fw-bold' : '' }" href="/product/list">전체 상품</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${menu eq 'board' ? 'active fw-bold' : '' }" href="/board/list">게시판</a>
				</li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item">
					<a class="nav-link ${menu eq 'admin' ? 'active fw-bold' : '' }" href="/admin/home">관리자</a>
				</li>
				</sec:authorize>
					<li class="nav-item dropdown ${menu eq 'my' ? 'active fw-bold' : '' }">
						<a class="nav-link dropdown-toggle" href="#" id="my-menu-link" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							마이 메뉴
						</a>
						<ul class="dropdown-menu" aria-labelledby="my-menu-link">
							<li><a class="dropdown-item" href="/my/carts">장바구니</a></li>
							<li><a class="dropdown-item" href="/my/orders">구매내역</a></li>
							<li><a class="dropdown-item" href="/my/reviews">내가 작성한 리뷰</a></li>
							<li><a class="dropdown-item" href="/my/pointhistory">포인트변경 이력</a></li>
							<li><a class="dropdown-item" href="/my/info">내정보 보기</a></li>
						</ul>
					</li>
			</ul>
			<!-- 인증된 사용자가 아닌 경우 -->
			<sec:authorize access="!isAuthenticated()">
				<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link ${menu eq 'login' ? 'active fw-bold' : '' }" href="/login">로그인</a>
						</li>
						<li class="nav-item">
						  	<a class="nav-link ${menu eq 'register' ? 'active fw-bold' : '' }" href="/register">회원가입</a>
						</li>
					</ul>
			</sec:authorize>
			<!-- 인증된 사용자인 경우 -->
			<sec:authorize access="isAuthenticated()">
					<span class="navbar-text">
					<strong>
						<sec:authentication property="principal.nickname" var="LOGIN_NICKNAME" />
						<sec:authentication property="principal.no" var="LOGIN_USERNO" />
						${LOGIN_NICKNAME }
					</strong>
					<small>님 환영합니다.</small></span>
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="/logout">로그아웃</a>
						</li>
					</ul>
			</sec:authorize>
			</div>
	</div>
</nav>
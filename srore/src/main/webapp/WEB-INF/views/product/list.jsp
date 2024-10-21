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
	<c:set var="menu" value="product" />
	<%@ include file="../common/nav.jsp" %>
</header>

<!-- 메인 컨텐츠 부  -->
<main>
	<div class="container my-3">
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-dark text-white fw-bold">전체 상품 리스트</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
			<div>
				<p>페이지번호: ${param.page }</p>
				<p>표시할 갯수: ${param.rows }</p>
				<p>검색 옵션: ${param.opt }</p>
				<p>검색 키워드: ${param.value }</p>
			</div>
				<form id="form-search" method="get" action="list">
					<input type="hidden" name="page" />
		  			<div class="row g-3">
		  				<div class="col-5">
		  					<select class="form-control" name="rows" onchange="changeRow()">
		  						<option value="5" ${param.rows eq 5 ? "selected" : "" }>5개씩 보기</option>
		  						<option value="10" ${empty param.rows or param.rows eq 10 ? "selected" : "" }>10개씩 보기</option>
		  						<option value="20" ${param.rows eq 20 ? "selected" : "" }>20개씩 보기</option>
		  					</select>
		  				</div>
		  				<div class="col-2">
		  					<select class="form-control" name="opt">
		  						<option value="none" ${param.opt eq 'name' ? 'selected' : '' }>상품명</option>
		  						<option value="maker" ${param.opt eq 'maker' ? 'selected' : '' }>제조회사</option>
		  						<option value="minPrice" ${param.opt eq 'minPrice' ? 'selected' : '' }>최소가격</option>
		  						<option value="maxPrice" ${param.opt eq 'maxPrice' ? 'selected' : '' }>최대가격</option>
		  					</select>
		  				</div>
		  				<div class="col-4">
		  					<input type="text" class="form-control" name="value">
		  				</div>
		  				<div class="col-1">
		  					<button type="button" class="btn btn-outline-primary" onclick="searchValue()">검색</button>
		  				</div>
		  			</div>
				</form>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-light">
					<table class="table">
						<colgroup>
							<col width="7%">
							<col width="15%">
							<col width="*">
							<col width="15%">
							<col width="15%">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>카테고리</th>
								<th>상품명</th>
								<th class="text-end">가격</th>
								<th class="text-end">할인가격</th>
							</tr>
						</thead>
						<tbody>
						<%--
							varStatus 속성
								+ 객체를 담는 변수명을 지정한다.
								+ <c:forEach >태그의 현재 반복상태 정보를 표현하는 객체가 전달된다.
								+ <c:forEach var="p" items="${products }" varStatus="x">
									${x.index } 	0부터 시작하는 인덱스가 표시된다.
									${x.count }		1부터 시작하는 순번이 표시된다.
									${x.first }		첫번째 값이면 true가 반환된다.
									${x.last }		마지막번째 값이면 true가 반환된다.
									 
						 --%>
						<c:forEach var="p" items="${products }" varStatus="loop">
							<tr>
								<td>${loop.count }</td>
								<td>${p.category.name }</td>
								<td><a class="text-decoration-none" href="detail?no=10">${p.name }</a></td>
								<td class="text-end"><fmt:formatNumber value="${p.price }"/> 원</td>
								<td class="text-end"><span class="text-danger"><fmt:formatNumber value="${p.discountPrice }"/></span> 원</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-12">
				<nav>
					<ul class="pagination justify-content-center">
					    <li class="page-item">
					    	<a class="page-link" onclick="changePage(1, event)" href="list?page=1&rows=${param.rows }&opt=${param.opt }&value=${param.value }">이전</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" onclick="changePage(1, event)" href="list?page=1&rows=${param.rows }&opt=${param.opt }&value=${param.value }">1</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" onclick="changePage(2, event)" href="list?page=2&rows=${param.rows }&opt=${param.opt }&value=${param.value }">2</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" onclick="changePage(3, event)" href="list?page=3&rows=${param.rows }&opt=${param.opt }&value=${param.value }">3</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" onclick="changePage(3, event)" href="list?page=3&rows=${param.rows }&opt=${param.opt }&value=${param.value }">다음</a>
					    </li>
				  	</ul>
				</nav>
			</div>
		</div>
		
	</div>
</main>

<!-- 푸터부 -->
<footer>
</footer>
<script>
	const form = document.querySelector('#form-search');
	const pageInput = document.querySelector('input[name=page]');
	
	function changeRow() {
		pageInput.value = 1;
		form.submit();
	}
	
	function searchValue() {
		pageInput.value = 1;
		form.submit();
	}
	
	function changePage(page, event) {
		event.preventDefault;
		pageInput.value = page;
		
		form.submit();
	}
</script>
</body>
</html>
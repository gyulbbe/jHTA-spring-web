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
				<form id="form-search" method="get" action="list">
					<input type="hidden" name="page" />
		  			<div class="row g-3">
		  				<div class="col-2">
		  					<select class="form-control" name="rows" onchange="changeRow()">
		  						<option value="5" ${param.rows eq 5 ? "selected" : "" }>5개씩 보기</option>
		  						<option value="10" ${empty param.rows or param.rows eq 10 ? "selected" : "" }>10개씩 보기</option>
		  						<option value="20" ${param.rows eq 20 ? "selected" : "" }>20개씩 보기</option>
		  					</select>
		  				</div>
		  				<div class="col-4 pt-2">
			  				<div class="form-check form-check-inline">
		                        <input class="form-check-input" type="radio" name="sort" value="date" onchange="changeSort()" ${empty param.sort or param.sort eq 'date' ? 'checked' : '' }>
		                        <label class="form-check-label" >최신순</label>
	                     	</div>
	                     	<div class="form-check form-check-inline">
		                        <input class="form-check-input" type="radio" name="sort" value="name" onchange="changeSort()" ${param.sort eq 'name' ? 'checked' : '' }>
		                        <label class="form-check-label" >이름순</label>
	                     	</div>
	                     	<div class="form-check form-check-inline">
		                        <input class="form-check-input" type="radio" name="sort" value="price" onchange="changeSort()" ${param.sort eq 'price' ? 'checked' : '' }>
		                        <label class="form-check-label" >가격순</label>
	                     	</div>
	                     </div>
		  				<div class="col-2">
		  					<select class="form-control" name="opt">
		  						<option value="name" ${param.opt eq 'name' ? 'selected' : '' }>상품명</option>
		  						<option value="maker" ${param.opt eq 'maker' ? 'selected' : '' }>제조회사</option>
		  						<option value="minPrice" ${param.opt eq 'minPrice' ? 'selected' : '' }>최소가격</option>
		  						<option value="maxPrice" ${param.opt eq 'maxPrice' ? 'selected' : '' }>최대가격</option>
		  					</select>
		  				</div>
		  				<div class="col-3">
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
		<!-- 페이지 내비게이션 시작 -->
		<c:if test="${not empty products }">
		<div class="row mb-3">
			<div class="col-12">
				<nav>
					<ul class="pagination justify-content-center">
					    <li class="page-item ${paging.first ? 'disabled' : '' } ">
					    	<a class="page-link" onclick="changePage(${paging.prevPage }, event)" href="list?page=${paging.prevPage }">이전</a>
					    </li>
					    <c:forEach var="num" begin="${paging.beginPage }" end="${paging.endPage }">
					    <li class="page-item ${paging.page eq num ? 'active' : '' }">
					    	<a class="page-link" onclick="changePage(${num }, event)" href="list?page=${num }">${num }</a>
					    </li>
						</c:forEach>
					    <li class="page-item ${paging.last ? 'disabled' : '' }">
					    	<a class="page-link" onclick="changePage(${paging.nextPage }, event)" href="list?page=${paging.nextPage }">다음</a>
					    </li>
				  	</ul>
				</nav>
			</div>
		</div>
		</c:if>
		<!-- 페이지 내비게이션 끝 -->
	</div>
</main>

<!-- 푸터부 -->
<footer>
</footer>
<script>
	const form = document.querySelector('#form-search');
	const pageInput = document.querySelector('input[name=page]');
	
	// 한 화면에 표시할 행의 갯수가 변경될 때
	function changeRow() {
		pageInput.value = 1;		// 표시할 행의 갯수가 바뀌면 무조건 1페이지 요청
		form.submit();
	}
	
	// 정렬방식이 변경될 때
	function changeSort() {
		pageInput.value = 1;		// 정렬방식이 바뀌면 무조건 1페이지 요청
		form.submit();
	}
	
	// 검색어를 입력하고 검색버튼을 눌렀을 때
	function searchValue() {
		pageInput.value = 1;
		form.submit();
	}
	
	function changePage(page, event) {
		event.preventDefault();
		pageInput.value = page;
		
		form.submit();
	}
</script>
</body>
</html>
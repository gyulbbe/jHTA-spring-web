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
				<div class="border p-2 bg-dark text-white fw-bold">게시글 목록</div>
			</div>
		</div>

			<div class="row mb-3">
				<div class="col">
					<div class="border p-2 bg-light">
						<table class="table">
							<colgroup>
								<col width="7%">
								<col width="*">
								<col width="15%">
								<col width="15%">
								<col width="15%">
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>등록일</th>
									<th>수정일</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td><a href="">연습</a></td>
									<td>홍길동</td>
									<td>2024-01-01</td>
									<td>2024-01-01</td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
				<div class="col-12 mt-3">
					<div class="text-end">
						<a href="register" class="btn btn-primary btn-sm">새 게시글</a>
					</div>
				</div>
			</div>
			<!-- 페이지 내비게이션 시작 -->
			<div class="row mb-3">
			<div class="col-12">
				<nav>
					<ul class="pagination justify-content-center">
					    <li class="page-item ">
					    	<a class="page-link" 
					    		onclick="changePage(1, event)" 
					    		href="list?page=1">이전</a>
					    </li>
					    
					<c:forEach var="num" begin="1" end="5">
					    <li class="page-item ${paging.page eq num ? 'active' : '' }">
					    	<a class="page-link" 
					    		onclick="changePage(${num }, event)" 
					    		href="list?page=${num }">${num }</a>
					    </li>
					</c:forEach>
					    
					    <li class="page-item ">
					    	<a class="page-link" 
					    		onclick="changePage(2, event)" 
					    		href="list?page=2">다음</a>
					    </li>
				  	</ul>
				</nav>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
				<form id="form-search" method="get" action="list">
					<input type="hidden" name="page" />
		  			<div class="row g-3">
		  				<div class="col-2">
		  					<select class="form-control" name="opt">
		  						<option value="title"> 제목</option>
		  						<option value="writer" > 작성자</option>
		  						<option value="content" > 내용</option>
		  					</select>
		  				</div>
		  				<div class="col-3">
		  					<input type="text" class="form-control" name="keyword" >
		  				</div>
		  				<div class="col-1">
		  					<button type="button" class="btn btn-outline-primary">검색</button>
		  				</div>
		  			</div>
				</form>
			</div>
		</div>
	</div>	
</main>

<!-- 푸터부 -->
<footer>

</footer>
</body>
</html>
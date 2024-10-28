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
				<div class="border p-2 bg-dark text-white fw-bold">게시글 등록폼</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
				<form class="border bg-light p-3"
					method="post" action="register"
					enctype="multipart/form-data">
					<div class="form-group mb-3">
						<label class="form-label">제목</label>
						<input type="text" class="form-control" name="title" />
					</div>
					<div class="form-group mb-3">
						<label class="form-label">내용</label>
						<textarea rows="10" class="form-control" name="content" ></textarea>
					</div>
					<div class="form-group mb-3">
						<label class="form-label">첨부파일</label>
						<input type="file" class="form-control" name="upfile" />
					</div>
					<div class="text-end">
						<button type="submit" class="btn btn-primary">등록</button>
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
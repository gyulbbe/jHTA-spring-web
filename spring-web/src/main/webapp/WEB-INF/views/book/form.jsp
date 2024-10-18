<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>새 도서 등록폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<form class="border bg-light p-3" method="post" action="add">
				<div class="form-group mb-3">
					<label class="form-label">제목</label>
					<input type="text" class="form-control" name="title" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">저자</label>
					<input type="text" class="form-control" name="author" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">출판사</label>
					<input type="text" class="form-control" name="publisher" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">가격</label>
					<input type="text" class="form-control" name="price" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">출판일자</label>
					<input type="text" class="form-control" name="pubDate" />
				</div>
				<div class="text-end">
					<a href="" class="btn btn-secondary">취소</a>
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
	</div>
	
</div>
</body>
</html>
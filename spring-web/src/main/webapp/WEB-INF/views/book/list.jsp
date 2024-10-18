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
			<h1>도서 목록</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="15%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>저자</th>
						<th>가격</th>
						<th>출판일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="book" items="${books }">
					<tr>
						<td>${book.no }</td>
						<td><a href="/book/detail?no=${book.no }"> ${book.title }</a></td>
						<td>${book.author }</td>
						<td><strong><fmt:formatNumber value="${book.price }" /></strong> 원</td>
						<td>${book.pubDate }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="text-end">
				<a href="/book/add" class="btn btn-primary btn-sm">새 책등록</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>
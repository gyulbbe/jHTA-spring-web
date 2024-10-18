<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈 페이지</h1>
	<p>${msg}</p>
	
	<h3>메뉴</h3>
	<ul>
		<li><a href="/employee/list">직원목록</a></li>
		<li><a href="/employee/register">신규 직원 등록</a></li>
	</ul>
</body>
</html>
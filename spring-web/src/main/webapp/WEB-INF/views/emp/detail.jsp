<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 상세정보</h1>
	
	<dl>
		<dt>직원아이디</dt>
		<dd>${emp.id}</dd>
		<dt>직원이름</dt>
		<dd>${emp.firstName} ${emp.lastName}</dd>
		<dt>직종아이디</dt>
		<dd>${emp.jobId}</dd>
	</dl>
</body>
</html>
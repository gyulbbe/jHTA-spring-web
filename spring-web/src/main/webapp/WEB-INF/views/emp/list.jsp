<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 목록</h1>
	<p>사원 목록을 확인하세요</p>
	
	<table border="1" style="width: 100%;">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>입사</th>
				<th>직종아이디</th>
			</tr>
		</thead>
		<tbody>
		<%--
			test="${empty employees }"
				+ empty 연산자는
					employees라는 이름으로 찾아지는 속성값이
					null이면 true다.
					""이면 true다.
					크기가 0이면 true다.
		 --%>
		 <c:if test="${empty employees }">
			<tr>
				<td colspan="4">조회된 정보가 없습니다.</td>
			</tr>
		</c:if>
		 <c:if test="${not empty employees }">
		<c:forEach var="e" items="${employees }">
			<tr>
				<td>${e.id }</td>
				<td>${e.firstName } ${e.lastName }</td>
				<td><fmt:formatDate value="${e.hireDate }" /></td>
				<td>${e.jobId }</td>
			</tr>
		</c:forEach>
		</c:if>
		</tbody>
	</table>
	<dl>
		<dd></dd>
	</dl>
</body>
</html>
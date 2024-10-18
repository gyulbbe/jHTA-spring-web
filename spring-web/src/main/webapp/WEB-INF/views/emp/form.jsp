<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>신규 직원 등록폼</h1>
	
	<form method="post" action="register">
		<div>
			<label>이름</label><br />
			<input type="text" name="firstName" /> - <input type="text" name="lastName" />
		</div>
		<div>
			<label>이메일</label><br />
			<input type="text" name="email" />
		</div>
		<div>
			<label>전화번호</label><br />
			<input type="text" name="phoneNumber" />
		</div>
		<div>
			<label>입사일</label><br />
			<input type="date" name="hireDate" />
		</div>
		<div>
			<label>직종아이디</label><br />
			<input type="text" name="jobId" />
		</div>
		<div>
			<label>급여</label><br />
			<input type="text" name="salary" />
		</div>
		<button type="submit">전송</button>
	</form>
</body>
</html>
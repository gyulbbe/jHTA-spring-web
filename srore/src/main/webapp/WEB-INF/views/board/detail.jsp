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
			<div class="col">
				<table class="table table-bordered">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<th>번호</th>
							<td>${board.no }</td>
							<th>작성자</th>
							<td>${board.user.nickname }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">${board.title }</td>
						</tr>
						<tr>
							<th>등록일</th>
							<td><fmt:formatDate value="${board.createdDate }" pattern="yyyy년 M월 d일 a h시 m분 s초"/> </td>
							<th>수정일</th>
							<td><fmt:formatDate value="${board.updatedDate }" pattern="yyyy년 M월 d일 a h시 m분 s초"/> </td>
						</tr>
						<c:if test="${not empty board.originalFilename }">
						<tr>
							<th>첨부파일</th>
							<td colspan="3">${board.originalFilename } <a href="download?no=${board.no}" class="btn btn-outline-primary btn-sm">다운로드</a></td>
						</tr>
						</c:if>
						<tr>
							<th>내용</th>
							<td colspan="3">
								<%--
									<c:out /> 태그
										+ XSS 공격을 방어한다.
										+ 사용자가 작성한 게시글 내용에 태그가 포함되어 있는 경우 글자를 이스케이프문자로 변환한다.
										<script> ----> &ltscript&gt;
								 --%>
								<c:out value="${board.content }"/>
							</td>
						</tr>
					</tbody>
				</table>
				
				<div class="text-end">
					<a href="" class="btn btn-warning">수정</a>
					<a href="" class="btn btn-danger">삭제</a>
					<a href="" class="btn btn-primary">목록</a>
				</div>
			</div>
		</div>
	</div>	
</main>

<!-- 푸터부 -->
<footer>

</footer>
</body>
</html>
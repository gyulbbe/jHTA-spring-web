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
							<td colspan="3">${board.originalFilename } <a href="filedown?no=${board.no}" class="btn btn-outline-primary btn-sm">다운로드</a></td>
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
					<button class="btn btn-success"
						onclick="openCommentFormModal()">댓글쓰기</button>
					<a href="" class="btn btn-warning">수정</a>
					<a href="" class="btn btn-danger">삭제</a>
					<a href="" class="btn btn-primary">목록</a>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12" id="box-comments"></div>
		</div>
	</div>
</main>
<div class="modal fade" id="modal-comment-form" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title">리뷰 등록폼</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <form method="post" action="/addComment">
            	<input type="hidden" name="boardNo" value="${board.no }" />
               <div class="form-group">
                  <label class="form-label">제목</label>
                  <input type="text" class="form-control" name="title" />
               </div>
               <div class="form-group">
                  <label class="form-label">내용</label>
                  <textarea rows="4" class="form-control" name="content"></textarea>
               </div>
            </form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            <button type="button" class="btn btn-primary" onclick="submitComment()">등록</button>
         </div>
      </div>
   </div>
</div>
<!-- 푸터부 -->
<footer>

</footer>
</body>
<script type="text/javascript">
	const commentFormModal = new bootstrap.Modal('#modal-comment-form');
	
	async function getComments() {
		let boardNo = document.querySelector("input[name=boardNo]").value;
		
		let response = await fetch("/board/comments/" + boardNo);
		let comments = await response.json();
		for (let comment of comments) {
			appendComment(comment);
		}
	}
	getComments();
	
	/*
		모달창에서 입력한 정보를 읽어서 서버로 보낸다.
	*/
	async function submitComment() {
		let value1 = document.querySelector("input[name=boardNo]").value;
		let value2 = document.querySelector("input[name=title]").value;
		let value3 = document.querySelector("textarea[name=content]").value;
		
		let data = {
				boardNo: value1,
				title: value2,
				content: value3
				}
		
		// 자바스크립트 객체를 json형식의 텍스트로 변환한다.
		let jsonText = JSON.stringify(data);
		
		// POST 방식으로 JSON 형식의 데이터를 서버로 보내기
		let response = await fetch("/board/addComment", {
			// 요청방식을 지정한다.
			method: "POST",
			// 요청메시지의 바디부에 포함된 컨텐츠의 형식을 지정한다.
			headers: {
				"Content-Type": "application/json"
			},
			// 요청메시지의 바디부에 서버로 전달할 json 형식의 텍스트 데이터를 포함시킨다.
			body: jsonText
		})
		// 서버가 보낸 응답데이터를 받는다.
		if (response.ok) {
			let comment = await response.json();
			appendComment(comment);
			commentFormModal.hide();
		}
	}
	
	function appendComment(comment) {
		/*
			comment -> {
				no: 10,
				title: "연습",
				content: "연습입니다.",
				user: {
					no: 5,
					nickname: "홍홍홍"
				}
			}
		*/
		let content = `
			<div class="card mb-3" id="comment-\${comment.no}">
				<div class="card-header">
					<span>\${comment.title}</span>
					<span class="float-end">
						<small>\${comment.user.nickname}</small>
						<small>\${comment.createdDate}</small>
					</span>
				</div>
				<div class="card-body">
					\${comment.content}
				</div>
				<div class="card-footer text-end">
					<button class="btn btn-danger btn-sm"
						onclick="removeComment(\${comment.no})">삭제</button>
				</div>
			</div>
		`;
		// 생성된 HTMl 컨텐츠가 추가될 엘리먼트를 획득한다.
		let box = document.querySelector("#box-comments");
		// 엘리먼트에 새로 생성한 HTML 컨텐츠를 추가한다.
		box.insertAdjacentHTML("beforeend", content);
	}
	
	/*
		리뷰 등록 모달창을 표시한다.
	*/
	function openCommentFormModal() {
		commentFormModal.show();
	}
</script>
</html>
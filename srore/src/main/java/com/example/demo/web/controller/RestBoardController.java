package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BoardService;
import com.example.demo.dto.CommentRegisterForm;
import com.example.demo.dto.RestResponseDto;
import com.example.demo.exception.StoreException;
import com.example.demo.security.LoginUser;
import com.example.demo.vo.Comment;

@RestController
@RequestMapping("/ajax")
public class RestBoardController {

	@Autowired
	private BoardService boardService;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delComment/{no}")
	public String deleteComment(@PathVariable("no") int commentNo,
			@AuthenticationPrincipal LoginUser loginUser) {
		try {
			boardService.deleteComment(commentNo, loginUser.getNo());
			return "success";
		} catch (StoreException e) {
			return "fail";
		}
	}
	
	@GetMapping("/comments/{no}")
	public ResponseEntity<RestResponseDto<List<Comment>>> comments(@PathVariable("no") int boardNo) {
		List<Comment> comments = boardService.getComments(boardNo);
		
		return ResponseEntity.ok(RestResponseDto.success(comments));
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/addComment")
	public Comment addComment(@RequestBody CommentRegisterForm form,
			@AuthenticationPrincipal LoginUser loginUser) {

		Comment comment = boardService.addNewComment(form, loginUser.getNo());
		
		return comment;
	}
}

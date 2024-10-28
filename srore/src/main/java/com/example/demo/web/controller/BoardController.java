package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.BoardService;
import com.example.demo.dto.BoardRegisterForm;
import com.example.demo.security.LoginUser;
import com.example.demo.util.FileUtils;
import com.example.demo.vo.Board;
import com.example.demo.vo.User;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Value("${upload.directory.board}")
	private String saveDirectory;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list() {
		
		return "board/list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public String form() {
		
		return "board/form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String register(BoardRegisterForm form,
			@AuthenticationPrincipal LoginUser loginUser) {

		// Board 객체를 생성한다.
		// 게시글 제목, 내용을 저장한다.
		Board board = new Board();
		board.setTitle(form.getTitle());
		board.setContent(form.getContent());
		// 인증된 사용자 정보를 이용해서 사용자번호가 담긴 User객체를 생성한다.
		User user = User.builder().no(loginUser.getNo()).build();
		// Board객체에 작성자를 저장한다.
		board.setUser(user);
		
		// 첨부파일을 저장된 디렉토리에 저장시키고 파일명을 반환받는다.
		MultipartFile multipartFile = form.getUpfile();
		if (!multipartFile.isEmpty()) {
			// 첨부파일을 지정된 디렉토리에 저장시키고 파일명을 반환받는다.
			String filename = FileUtils.saveMultipartFile(multipartFile, saveDirectory);
			board.setFilename(filename);
		}
		// Board객체에는 제목, 내용, 작성자, 첨부파일명(null 가능)이 있다.
		
		boardService.addNewBoard(board);
		
		return "redirect:list";
	}
	
}
package com.example.demo.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.BoardService;
import com.example.demo.dto.BoardRegisterForm;
import com.example.demo.dto.ListDto;
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
	public String list(
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "opt", required = false) String opt,
			@RequestParam(name = "keyword", required = false) String keyword,
			Model model) {
		
		Map<String, Object> condition = new HashMap<>();
		condition.put("page", page);
		if (StringUtils.hasText(keyword)) {
			condition.put("opt", opt);
			condition.put("keyword", keyword);
		}
		// 검색조건을 전달해서 게시글 목록 조회
		ListDto<Board> dto = boardService.getBoards(condition);
		// List<Board>를 "boards"로 모델에 저장
		model.addAttribute("boards", dto.getData());
		model.addAttribute("paging", dto.getPaging());
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
			String originalFilename = multipartFile.getOriginalFilename();
			String filename = System.currentTimeMillis() + originalFilename;
			FileUtils.saveMultipartFile(multipartFile, saveDirectory, filename);
			board.setFilename(filename);
		}
		// Board객체에는 제목, 내용, 작성자, 첨부파일명(null 가능)이 있다.
		
		boardService.addNewBoard(board);
		
		return "redirect:list";
	}
	
	/**
	 * 
	 * @param no
	 * @param model
	 * @return
	 */
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Board board = boardService.getBoardDetail(no);
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadfile(){
		
		return null;
	}
	
}
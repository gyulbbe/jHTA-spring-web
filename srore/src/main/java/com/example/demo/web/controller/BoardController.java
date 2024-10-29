package com.example.demo.web.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
	
	/*
	 * org.springframework.core.io.Resource
	 * + 스프링에서 저수준 자원(Low Level Resource)에 대한 처리를 추상화한 인터페이스다.
	 * + Resource 인터페이스를 이용해서 자원의 종류에 상관없이 동일한 방식으로 저수준 자원을 접근할 수 있도록 지원한다.
	 * + 다양한 구현클래스
	 * 		urlResource
	 * 		ClassPathResource
	 * 		SystemResource
	 * 		InputStreamResource
	 * 		ByteArrayResource
	 * + FileSystemResource는 파일시스템의 특정위치에 저장된 파일자원을 읽어 올 수 있다.
	 */
	@GetMapping("/download")
	   public ResponseEntity<Resource> downloadfile(int no) throws Exception {
		// 게시글 정보 조회
	      Board board = boardService.getBoardDetail(no);
	      // 파일명 조회
	      String filename = board.getFilename();
	      String originalFilename = board.getOriginalFilename();
	      originalFilename = URLEncoder.encode(originalFilename, "utf-8");
	      // 디렉토리의 파일명을 이용해서 해당 파일을 표현한 File객체 생성
	      File file = new File(new File(saveDirectory), filename);
	      // file객체가 표현하는 자원을 읽어오는 FileSystemResource객체를 생성
	      FileSystemResource resource = new FileSystemResource(file);
	      
	      /*
	       * ResponseEntity.ok(): HTTP 응답코드 200으로 설정
	       * .header(응답헤더명, 응답헤더값) : 응답메시지의 헤더부에 정보를 설정
	       * .body(데이터) : 응답메시지의 바디부에 데이터를 설정
	       * 
	       * HttpHeader.CONTENT_DISPOSITION
	       *  + 응답메시지로 보내는 컨텐츠가 브라우저 내부에서 보여질 것인지,
	       *    다운로드되어 저장될 것인지를 알려주는 헤더정보다.
	       *  + 사용예
	       *  		응답헤더명				응답헤더값
	       *        ---------------------------------
	       *  		Content-Disposition: inline		브라우저 내부에 표현
	       *  		Content-Disposition: attachment	컴퓨터에 저장
	       */
	      return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + originalFilename)
	            .body(resource);
	   }
}
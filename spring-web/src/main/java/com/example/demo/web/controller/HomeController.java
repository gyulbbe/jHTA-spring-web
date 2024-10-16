package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/*
	 * 요청 URL
	 *  http://localhost 혹은 http://localhost/
	 * 요청 파라미터
	 *  없음
	 * 반환값
	 *  "home" -> "/WEB-INF/views/home.jsp"로 내부이동시킨다.
	 */
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("msg", "홈페이지 방문을 환영합니다.");
		
		return "home";
	}
}
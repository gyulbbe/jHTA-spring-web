package com.example.demo.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.CustomUserDetails;

@Controller
@RequestMapping("/my")
public class UserController {

	@GetMapping("/info")
	public String detail(Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		System.out.println("사용자 번호: " + userDetails.getNo());
		System.out.println("닉네임: " + userDetails.getNickname());

		return "user/detail";
	}
}

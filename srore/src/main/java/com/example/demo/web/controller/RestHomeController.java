package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.dto.RestResponseDto;

@RestController
public class RestHomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/ajax/check-email")
	public ResponseEntity<RestResponseDto<String>> emailCheck(String email) {
		System.out.println("전달받은 email: " + email);
		boolean isExist = userService.isExistEmail(email);
		String data = isExist ? "exists" : "none";
		
		return ResponseEntity.ok(RestResponseDto.success(data));
	}
}

package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.StoreException;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("registerForm", new UserRegisterForm());
		
		return "register-form";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerForm") UserRegisterForm form, BindingResult errors) {
		
		// 유효성 검증을 통과하지 못하면 register-form
		if(errors.hasErrors()) {
			return "register-form";
		}
		
		// 추가적인 유효성 검증 실시하기
		if (!form.getPassword().equals(form.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", null, "비밀번호가 일치하지 않습니다.");
			return "register-form";
		}
		
		try {
			userService.addNewUser(form);
		} catch (StoreException e) {
			errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
			return "register-form";
		}
		
		return "redirect:/";
	}
}

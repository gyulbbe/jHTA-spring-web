package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.AlreadyUsedEmailException;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "login-form";
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
		} catch (AlreadyUsedEmailException e) {
			errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
			return "register-form";
		} 
//		catch (AlreadyUsedNickNmaeException e) {
//			errors.rejectValue("nickname", null, "이미 사용중인 닉네임입니다.");
//			return "register-form";
//		} catch (AlreadyUsedTelException e) {
//			errors.rejectValue("email", null, "이미 사용중인 전화번호입니다.");
//			return "register-form";
//		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/check-email")
	@ResponseBody
	public String emailCheck(String email) {
		System.out.println("전달받은 email: " + email);
		boolean isExist = userService.isExistEmail(email);
		return isExist ? "exists" : "none";
	}
}

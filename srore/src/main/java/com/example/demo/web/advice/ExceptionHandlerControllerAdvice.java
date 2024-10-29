package com.example.demo.web.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.StoreException;

/*
 * @ControllerAdvice
 *  - 모든 컨트롤러에서 공통으로 사용되는 기능을 정의하는 클래스임을 나타낸다.
 *  - 주로, 예외처리 관련 내용을 정의한다.
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String hadleException(Exception e) {
		return "error/server-error";
	}
	
	@ExceptionHandler(StoreException.class)
	public String handleStoreException(StoreException e, Model model) {
		model.addAttribute("msg", e.getMessage());
		return "error/business-error";
	}
}

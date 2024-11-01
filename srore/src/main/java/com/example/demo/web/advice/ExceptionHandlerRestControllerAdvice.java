package com.example.demo.web.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.RestResponseDto;
import com.example.demo.exception.RestStoreException;

@RestControllerAdvice
public class ExceptionHandlerRestControllerAdvice {

	@ExceptionHandler(RestStoreException.class)
	public ResponseEntity<RestResponseDto<Void>> handlerStoreException(RestStoreException e) {
		
		String errorMessage = e.getMessage();
		
		return ResponseEntity.internalServerError().body(RestResponseDto.fail(errorMessage));
	}
}

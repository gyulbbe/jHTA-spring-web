package com.example.demo.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.example.demo.dto.RestResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		String requestURI = request.getRequestURI();
		
		if (requestURI.startsWith("/ajax")) {
			// 응답메세지객체를 생성한다.
			RestResponseDto<Void> dto 
				= RestResponseDto.fail(HttpServletResponse.SC_FORBIDDEN, "접근권한이 없습니다.");
			
			// 응답메세지객체를 json 형식의 텍스트로 변환한다.
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonText = objectMapper.writeValueAsString(dto);
			
			// HttpServletResponse 객체를 이용해서 응답을 보낸다.
			// 응답컨텐츠 타입을 지정한다.
			response.setContentType("application/json; charset=utf-8");
			// 응답메세지의 HTTP 응답코드를 401로 설정한다.
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			// 브라우저로 응답을 보낸다.
			response.getWriter().write(jsonText);			
		} else {
			response.sendRedirect("/login?error=access-denied");
		}
	}

	
}

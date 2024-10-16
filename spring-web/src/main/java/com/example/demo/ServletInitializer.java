package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * Spring MVC관련 추가설정을 정의하는 클래스다.
 * 패키징 타입을 war로 설정했을 때 생성되는 클래스다.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringWebApplication.class);
	}

}

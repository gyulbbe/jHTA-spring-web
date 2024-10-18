package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration
 * 		- 수동으로 객체를 등록시킬 때 사용되는 어노테이션이다.
 * 		- @Bean 어노테이션을 이용해서 수동으로 등록시킬 객체를 생성하는 메소드를 작성한다.
 * 		  XMl의 <bean /> 태그 역할을 대신한다.
 */
@Configuration
public class CommonConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT);
		
		return modelMapper;
	}
}
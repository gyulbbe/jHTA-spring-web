package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BoardRegisterForm {

	private String title;
	private String content;
	private MultipartFile upfile; // 얘는 Board의 filename과 이름이 달라야 한다, 파일이 없어도 null은 아니고 비어있다.
}

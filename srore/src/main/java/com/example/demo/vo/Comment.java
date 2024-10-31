package com.example.demo.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Alias("Comment")
public class Comment {

	private int no;
	private String title;
	private String content;
	private Date createdDate;
	private Board board;
	private User user;
}

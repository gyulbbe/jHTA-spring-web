package com.example.demo.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Alias("Board")
public class Board {
	private int no;
	private String title;
	private String content;
	private String filename;
	private Date createdDate;
	private Date updatedDate;
	private User user;
}
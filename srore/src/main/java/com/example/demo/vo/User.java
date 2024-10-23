package com.example.demo.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Alias("User")
public class User {

	private int no;
	private String email;
	private String password;
	private String nickname;
	private String tel;
	private int point;
	private String enabled;
	private Date createdDate;
	private Date updatedDate;
}

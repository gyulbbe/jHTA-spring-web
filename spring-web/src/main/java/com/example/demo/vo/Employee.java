package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 모든 getter 메소드를 추가한다.
@Getter
// 모든 setter 메소드를 추가한다.
@Setter
// 기본 생성자 메소드를 추가한다.
@NoArgsConstructor
// 모든 매개변수를 초기화하는 생성자 메소드를 추가한다.
@AllArgsConstructor
// 모든 toString() 메소드를 추가한다.
@ToString
@Builder
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private Integer managerId;
	private Integer departmentId;
}
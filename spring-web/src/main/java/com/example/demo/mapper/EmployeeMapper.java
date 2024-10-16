package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Employee;

/*
 * 매퍼 인터페이스
 * 		- EMPLOYEES 테이블에 대한 데이터베이스 엑세스 메소드를 정의한다.
 * 		- 이 인터페이스를 스캔해서 매퍼파일에 정의한 SQL를 실행해서 실제 데이터베이스 엑세스 작업을 수행하는 구현객체는 mybatis가 생성해서 스프링의 빈으로 등록한다.
 */
@Mapper
public interface EmployeeMapper {
	
	Employee getEmployeeById(@Param("id") int no);
	List<Employee> getAllEmployees();
}

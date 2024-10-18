package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.EmployeeRegisterForm;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.vo.Employee;

/*
 * 서비스 클래스
 * 		- 핵심 업무로직(서비스 로직, 비즈니스 로직)을 구현하는 클래스다.
 * 		- 업무로직을 구현하기 위해서 데이터베이스 엑세스 작업이 필수다.
 * 			* 데이터베이스 엑세스 작업이 구현된 객체를 의존성 주입받아야 한다.
 * 			* 직원정보에 대한 CRUD작업이 정의된 EmployeeMapper타입의 객체를 의존성 주입받아야 한다.
 * 			* mybatis가 EmployeeMapper인터페이스를 구현한 구현객체를 스프링 컨테이너에 빈으로 등록했기 때문에 그 객체가 의존성 주입된다.
 * 			
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * 지정된 사원 아이디에 해당하는 사원의 상세정보를 제공하는 서비스 메소드다.
	 * @param id 사원아이디
	 * @return 사원상세정보
	 */
	public Employee getEmployeeDetail(int id) {
		Employee employee = employeeMapper.getEmployeeById(id);
		return employee;
	}
	
	/**
	 * 지정된 부서아이디에 소속된 직원목록정보를 제공하는 서비스 메소드다.
	 * @param deptId 부서아이디
	 * @return 부서아이디가 0이면 모든 직원정보를 반환하고, 그 외는 해당 부서의 직원정보를 반환한다.
	 */
	public List<Employee> getEmployees(int deptId) {
		List<Employee> employees = employeeMapper.getAllEmployees(deptId);
		return employees;
	}

	/**
	 * 신규 직원 정보를 전달받아서 등록하는 서비스 메소드다.
	 * @param form 신규 직원정보가 포함된 객체
	 */
	public void addNewEmployee(EmployeeRegisterForm form) {
		// Employee객체를 생성해서 EmployeeRegisterForm 객체의 값을 복사한다.
		Employee employee = modelMapper.map(form, Employee.class);
		System.out.println("직원정보: " + employee);
	}
}

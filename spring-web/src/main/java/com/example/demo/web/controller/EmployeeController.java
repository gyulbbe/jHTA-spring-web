package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.EmployeeService;
import com.example.demo.vo.Employee;

/*
 * 컨트롤러 클래스
 * 		- 사원정보 관련 HTTP 요청을 처리하는 컨트롤러 클래스다.
 *  	- 사원정보 관련 HTTP 요청을 처리하기 위해서는 업무로직 메소드의 호출이 필수다.
 *  		* EmployeeService 객체에 의존한다.
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * 요청 URL
	 * 		http://localhost/employees/detail?id=100
	 * 요청 파라미터
	 * 		id=100
	 */
	@GetMapping("/employee/detail")
	public String detail(int id, Model model) {
		// 업무로직을 호출해서 직원 상세정보 조회하기
		Employee employee = employeeService.getEmployeeDetail(id);
		// jsp에 전달하기 위해서 Model객체에 Employee객체담기
		model.addAttribute("emp", employee);
		
		return "emp/detail";
	}
}

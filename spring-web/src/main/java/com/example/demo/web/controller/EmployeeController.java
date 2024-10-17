package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.EmployeeService;
import com.example.demo.vo.Employee;

/*
 * 컨트롤러 클래스
 * 		- 사원정보 관련 HTTP 요청을 처리하는 컨트롤러 클래스다.
 *  	- 사원정보 관련 HTTP 요청을 처리하기 위해서는 업무로직 메소드의 호출이 필수다.
 *  		* EmployeeService 객체에 의존한다.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * 요청 URL
	 * 		http://localhost/employees/detail?id=100
	 * 요청 파라미터
	 * 		id=100
	 */
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		// 업무로직을 호출해서 직원 상세정보 조회하기
		Employee employee = employeeService.getEmployeeDetail(id);
		// jsp에 전달하기 위해서 Model객체에 Employee객체담기
		model.addAttribute("emp", employee);
		
		return "emp/detail";
	}
	
	/*
	 * 요청 URL
	 * 		http://localhost/employee/list
	 * 		http://localhost/employee/list?deptNo=10
	 */
	@GetMapping("/list")
	public String employees(@RequestParam(name = "dept", required = false, defaultValue = "0") int dept,
							Model model) {
		List<Employee> employees = employeeService.getEmployees(dept);
		model.addAttribute("employees", employees);
		return "emp/list";
	}
}

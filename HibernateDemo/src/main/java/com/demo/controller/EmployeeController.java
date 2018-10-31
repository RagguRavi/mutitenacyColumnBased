package com.demo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Employee;
import com.demo.service.EmployeeService;
import com.demo.util.Tenant;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/saveEmploye",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee createEmployee(@Valid @RequestBody Employee employee1,BindingResult bindingResult) {
		System.out.println(employee1);
		if(!bindingResult.hasErrors()) {
		Employee employee = new Employee();
		employee.setFirstName(employee1.getFirstName());
		employee.setLastName(employee1.getLastName());
		
		return employeeService.createEmployee(employee);
		} else {
			return new Employee();
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/listEmploye",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeService.getAllEmployee();
		return list;
	}
	
	@GetMapping("/ping")
	@ResponseBody
	public String simplePing() {
			return "OK";
	}
	
	
	@GetMapping(value = "/check",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> test() {
		System.out.println("---------This is test -----------------");
		List<Employee> list = new ArrayList<>();
		Tenant.doWithoutTenant(() -> {
			list.addAll(employeeService.getAllEmployee());
		});
		
		return list;
	}
	
}

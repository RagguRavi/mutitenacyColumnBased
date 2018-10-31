package com.demo.service;

import java.util.List;

import com.demo.domain.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployee();
}

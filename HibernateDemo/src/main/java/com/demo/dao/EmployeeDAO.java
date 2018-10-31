package com.demo.dao;

import java.util.List;

import com.demo.domain.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);
	public List<Employee> getAllEmployee();
}

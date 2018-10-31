package com.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.EmployeeDAO;
import com.demo.domain.Employee;
import com.demo.repository.EmployeeRespository;

@Service("employeService")
public class EmployeeServiceImpl implements EmployeeService {

	@PersistenceContext
	public EntityManager entityManager;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	EmployeeRespository employeeRespository;

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		employee = employeeRespository.save(employee);
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeRespository.findAll();
	}

}

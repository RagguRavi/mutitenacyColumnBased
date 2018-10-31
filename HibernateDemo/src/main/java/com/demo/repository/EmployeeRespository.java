package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.domain.Employee;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {
	public List<Employee> findAll();
	public List<Employee> findByFirstNameAndLastNameAllIgnoreCase(String firstName,String LastName);
}

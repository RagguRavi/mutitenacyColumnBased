package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.domain.AdminUser;

public interface AdminUserRepository extends CrudRepository<AdminUser, Long> {

	public List<AdminUser> findByUserNameAndPasswordAllIgnoreCase(String userName,String password);
	public List<AdminUser> findAll();
}

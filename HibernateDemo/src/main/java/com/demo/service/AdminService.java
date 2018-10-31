package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AdminDAO;
import com.demo.domain.AdminUser;
import com.demo.repository.AdminUserRepository;

@Service("adminService")
public class AdminService {
	
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	AdminUserRepository adminUserRepository;
	
	@Transactional
	public AdminUser addNewUser(AdminUser adminUser) {
		adminUser.setTenantId(adminUser.getUserName());
		return adminUserRepository.save(adminUser);
	}
	
	@Transactional
	public AdminUser getUser(String userName,String password) {
		List<AdminUser> list = adminUserRepository.findByUserNameAndPasswordAllIgnoreCase(userName, password);
		if(list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
		
	}
}

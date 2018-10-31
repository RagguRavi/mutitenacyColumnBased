package com.demo.dao;

import org.springframework.stereotype.Repository;

import com.demo.domain.AdminUser;

@Repository
public class AdminDAO {
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	public AdminUser save(AdminUser adminUser) {
//		sessionFactory.getCurrentSession().save(adminUser);
		return adminUser;
	}
	
	public AdminUser getUser(String userName, String password) {
		/*Criteria userCreteria =  sessionFactory.getCurrentSession().createCriteria(Employee.class);
		userCreteria
		.add(Restrictions.eq("userName", userName))
		.add(Restrictions.eq("password", password))
		.setMaxResults(1);
        return (AdminUser)userCreteria.uniqueResult();*/
		return null;
	}
}

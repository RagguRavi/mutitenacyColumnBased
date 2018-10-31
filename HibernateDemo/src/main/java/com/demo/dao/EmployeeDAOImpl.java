package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.domain.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	/*@Autowired
	SessionFactory sessionFactory;*/
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
//		sessionFactory.getCurrentSession().get
//		Criteria employeeCreteria =  sessionFactory.getCurrentSession().createCriteria(Employee.class);
		
		/*CriteriaBuilder criteriaBuilder =session.getCriteriaBuilder();
		CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
		
		Root<Employee> root = query.from(Employee.class);
        query.select(root);
        org.hibernate.query.Query<Employee> q=session.createQuery(query);*/
//        List<Employee> employees=employeeCreteria.list();
		return null;
	}

}

package com.demo.aspect;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.demo.domain.Employee;
import com.demo.util.TenantContext;

@Aspect
@Component
public class EmployeeServiceAspect {

//  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @PersistenceContext
  public EntityManager entityManager;
  
  // only applicable to employee service
  @Before("allServiceMethod()")
  public void aroundExecution(JoinPoint pjp) throws Throwable {
	 System.out.println(pjp.getTarget()+"\t"+pjp.getSignature()+"\t"+pjp.getThis()+"\t");
	  System.out.println("Hey i am execution ");
	  String tenantId = TenantContext.getCurrentTenant();
	  
	  if(tenantId != null && !"".equals(tenantId)) {
		  org.hibernate.Filter filter = entityManager.unwrap(Session.class).enableFilter("tenantFilter");
		  filter.setParameter("tenantId", TenantContext.getCurrentTenant());
		  filter.validate();
	  }
  }
  
  /*@Before("employeObj(employee)")
  public void beforeEmployee(JoinPoint pjp,Employee employee) {
	  System.out.println("-------------befor employe obj--------------"+employee);
	  employee.setTenantId(TenantContext.getCurrentTenant());
  }*/
  
  @Pointcut("execution(* com.demo.service.*.*(..))")
  public void allServiceMethod() {}
  
  @Pointcut("execution(* com.demo.service.EmployeeService.*(..)) && args(employee,..)")
  public void employeObj(Employee employee) {}
  
}

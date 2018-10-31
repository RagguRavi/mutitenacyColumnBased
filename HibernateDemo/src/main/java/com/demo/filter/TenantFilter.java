package com.demo.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.demo.util.TenantContext;


public class TenantFilter implements Filter {


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
	  System.out.println("Filter is initialized");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	  HttpServletRequest request = (HttpServletRequest) servletRequest;
	
	  String tenantHeader =request.getSession().getAttribute("tenantIdenfier").toString();
	  System.out.println("==========Do filter method ================="+tenantHeader);
	  if (tenantHeader != null && !tenantHeader.isEmpty()) {
		  TenantContext.setCurrentTenant(tenantHeader);
	  } else { //When we are not getting any tenant id from the session then setting it to 0 
		  System.out.println("Tenant identifier is empty");
		  TenantContext.setCurrentTenant("0");
		 
	  }
	  filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
  }
}

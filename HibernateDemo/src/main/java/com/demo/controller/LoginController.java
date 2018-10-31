package com.demo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.domain.AdminUser;
import com.demo.service.AdminService;

@Controller
@RequestMapping(value = {"", "/"})
public class LoginController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = {"", "/","/login"}, method = RequestMethod.GET)
	public String login() {
		System.out.println("i am in controller");
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String checkUser(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpSession session) {
		AdminUser user = adminService.getUser(userName, password);
		if(user != null) {
			session.setAttribute("tenantIdenfier", user.getTenantId());
			return "index";
		} else {
			return "redirect:/login";
		}
	}
}

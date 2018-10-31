package com.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.domain.AdminUser;
import com.demo.service.AdminService;

@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@Autowired
	AdminService adminService;
	
	
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String registerNewUser(@Valid @ModelAttribute("user") AdminUser adminUser,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/user/add";
		} else {
			adminService.addNewUser(adminUser);
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public String registerNewUser1(Model model) {
		System.out.println("----------- I am in register new user ---------------");
		model.addAttribute("user", new AdminUser());
		return "register";
	}
	
	
	
}

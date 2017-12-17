package com.avinash.spring.secuirty.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avinash.spring.secuirty.example.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@RequestMapping(value="admin", method=RequestMethod.GET)
 public String adminloginPage(ModelMap map, Principal principal){
		System.out.println("UserName  " + 		principal.getName());
	 return "admin";
 }
	
	
	@RequestMapping(value="adminservice", method=RequestMethod.GET)
 public String adminService(ModelMap map, Principal principal){
		adminService.performSomeAdminService();
	 return "admin";
 }

	@RequestMapping(value="admin/service", method=RequestMethod.GET)
 public String adminsubService(ModelMap map, Principal principal){
		adminService.performSomeAdminService();
	 return "admin";
 }

}

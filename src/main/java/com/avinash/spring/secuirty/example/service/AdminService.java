package com.avinash.spring.secuirty.example.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Secured("ROLE_ADMIN")
	public void performSomeAdminService(){
		System.out.println(" Perfom some admin");
	}
	
}

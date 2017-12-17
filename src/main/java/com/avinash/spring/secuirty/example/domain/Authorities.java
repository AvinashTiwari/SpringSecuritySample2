package com.avinash.spring.secuirty.example.domain;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
private String authority;
	public Authorities(String username, String authority) {
	this.username = username;
	this.authority = authority;
}


	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

	
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.username;
	}

}

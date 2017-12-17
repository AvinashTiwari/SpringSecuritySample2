package com.avinash.spring.secuirty.example.domain;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDomain implements UserDetails{

	private String userName;
	private String password;
	private Set<Authorities> authorities;
	
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}



	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	
	

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if( this == obj)
		{
			return true;

		}
		
		if( obj == null)
		{
			return false;

		}
        
		if(getClass() != obj.getClass())
		{
			return false;
		}
		
		UserDomain other = (UserDomain) obj;
		if(userName == null)
		{
			if(other.userName == null)
			{
				return false;
			}else if(!userName.equals(other.userName))
			{
				return false;
			}
			
		}
		
		return true;
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime  = 31;
		int result = 1;
		result =  prime * result + ((userName == null) ? 0 : userName.hashCode() );
		
		
		
		return result;
	}
	
	

}

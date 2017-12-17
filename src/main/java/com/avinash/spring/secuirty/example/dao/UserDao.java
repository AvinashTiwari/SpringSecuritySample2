package com.avinash.spring.secuirty.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.avinash.spring.secuirty.example.domain.Authorities;
import com.avinash.spring.secuirty.example.domain.UserDomain;

@Repository
public class UserDao implements UserDetailsService {

	@Autowired
    private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String  sql = "select * from users where username =?";
		UserDomain user = null;
		List<UserDomain> userDomian =  getJdbcTemplate()
				.query(sql, new Object[] {username}, new RowMapper<UserDomain>()
						{

							public UserDomain mapRow(ResultSet rs, int rownum) throws SQLException {
								UserDomain user = new UserDomain();
								
								if(user.getUserName() == null)
								{
									user.setUserName(rs.getString("username"));
								}
								
							  if(user.getPassword() ==  null)
							  {
								  user.setPassword(rs.getString("password"));
							  }
								
								
								return user;

							}
					
						});
		
		    if(userDomian.size() == 0)
		    {
		      System.out.println(" No record is found");	
		    }
		    else
		    {
		    	user = userDomian.get(0);
		    }
		  
		    sql = "select authority from authorities where  username = ?";
		    
		    List<String> authorities = getJdbcTemplate().queryForList(sql, new Object[] {username}, String.class);
		    Set<Authorities> userAuth = new HashSet<Authorities>();
            for(String authroity : authorities)
            {
            	userAuth.add(new Authorities(username , authroity));
            }
		    
            user.setAuthorities(userAuth);
            
		return user;
	}
	
	private JdbcTemplate getJdbcTemplate(){
		if(jdbcTemplate == null)
		{
			return new JdbcTemplate(dataSource);
		}
		else
		{
			return this.jdbcTemplate;
		}
	}

}

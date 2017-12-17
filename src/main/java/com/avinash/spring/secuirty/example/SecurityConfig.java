package com.avinash.spring.secuirty.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.avinash.spring.secuirty.example.dao.UserDao;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled= true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     @Autowired
     private DataSource dataSource;
     
     @Autowired
     private  BCryptPasswordEncoder bcryEncoder;
     @Autowired
     private  UserDao userdao;

     
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/* (1)
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("password")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("password")
		.roles("USER","ADMIN");*/
		
		/* (2)
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(bcryEncoder);*/
		
		auth.userDetailsService(userdao)
		.passwordEncoder(bcryEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/admin**/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.and()
		.httpBasic()
		.and()
		.sessionManagement()
		.maximumSessions(1);
	}

}

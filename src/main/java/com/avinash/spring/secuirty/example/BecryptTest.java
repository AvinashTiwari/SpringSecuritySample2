package com.avinash.spring.secuirty.example;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BecryptTest {
	@Test
	public void beCrypTest() {
		BCryptPasswordEncoder nw  = new BCryptPasswordEncoder();
		String str = nw.encode("test");
		
		System.out.println(str);
		
	}
}

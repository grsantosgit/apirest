package com.spring.apirest.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwrd = new BCryptPasswordEncoder();
		System.out.println(passwrd.encode("123456"));
	
	}

}

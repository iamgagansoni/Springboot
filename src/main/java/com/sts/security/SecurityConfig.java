package com.sts.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class SecurityConfig {


	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}


	
}

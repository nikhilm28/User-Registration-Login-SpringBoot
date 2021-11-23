package com.spring.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.entity.User;
import com.spring.entity.UserRegistration;

public interface UserService extends UserDetailsService{
	
	User findByEmail(String email);
	
	User saveUser(UserRegistration userRegistration);
}

package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.User;
import com.spring.entity.UserRegistration;
import com.spring.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public UserRegistration userRegistration()
	{
		return new UserRegistration();
	}
	
	@GetMapping
	public String showForm()
	{
		return "registration";
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute("user") UserRegistration userRegistration)
	{
		User olduser = userService.findByEmail(userRegistration.getEmail());
		if(olduser != null)
		{
			return "registration";
		}
		
		userService.saveUser(userRegistration);
		return "redirect:/registration";
	}

}

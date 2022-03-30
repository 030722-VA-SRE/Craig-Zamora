package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.UserService;

@RestController 
public class AuthController {

	private UserService us;

	@Autowired
	public AuthController(UserService us) {
		super();
		this.us = us;
	}
	
	
	
}

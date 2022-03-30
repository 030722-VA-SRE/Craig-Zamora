package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Beer;
import com.revature.services.BeerService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService us;
	private BeerService bs;

	@Autowired
	public UserController(UserService us, BeerService bs) {
		super();
		this.us = us;
		this.bs = bs;
	}
	
	
	

	
	
}

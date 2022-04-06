package com.revature.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.BeerService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService us;
	private BeerService bs;
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	

	@Autowired
	public UserController(UserService us, BeerService bs) {
		super();
		this.us = us;
		this.bs = bs;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		log.info("HTTP Request for all users");
		return new ResponseEntity<>(us.getAllUsers(),HttpStatus.OK);
	}
	

	
	
}

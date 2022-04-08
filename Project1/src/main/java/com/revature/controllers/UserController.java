package com.revature.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Beer;
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
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		log.info("HTTP Request for all users");
		return new ResponseEntity<>(us.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
		if (token == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		}

		// log.info("HTTP Request for all users by id");

		return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);

	}

//	@GetMapping("/{id}")
//	public ResponseEntity<List<Beer>> getBeersId(@PathVariable("id") int id, @RequestHeader("Authorization") String token){
//		if(token == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//			
//		}
//
//			//log.info("HTTP Request for all users by id");	
//	
//			return new ResponseEntity<>(us.getUserBeers(1),  HttpStatus.OK);
//
//	}

	@PostMapping // Needs to be string to have entity print out
	public ResponseEntity<String> createUser(@RequestBody User user) {

		User newUser = us.createUser(user);

		log.info("New user " + newUser.getUsername() + " added to database");
		return new ResponseEntity<>("New user " + newUser.getUsername() + " added to database", HttpStatus.CREATED);

	}
	


}

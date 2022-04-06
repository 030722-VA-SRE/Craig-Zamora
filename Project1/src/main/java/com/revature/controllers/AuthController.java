package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserService us;
	private AuthService as;

	@Autowired
	public AuthController(UserService us, AuthService as) {
		super();
		this.us = us;
		this.as = as;
	}

	@PostMapping
	public ResponseEntity<UserDTO> login(@RequestParam("username") String username, @RequestParam("password") String password) {

		// principal = null if login fails
		UserDTO principal = as.login(username, password);

		if (principal == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		// Set token as id:username
		String token = as.generateToken(principal);
		// create Http Headers
		HttpHeaders hh = new HttpHeaders();
		// Set tokenName, value
		hh.set("Authorization", token);

		 return new ResponseEntity<>(principal, hh, HttpStatus.FORBIDDEN);
	}

}

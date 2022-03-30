package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Beer;
import com.revature.services.AuthService;
import com.revature.services.BeerService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/beers")
public class BeerController {
	
	private BeerService bs;
	private UserService us;
	private AuthService as;
	
	@Autowired
	public BeerController(BeerService bs, UserService us, AuthService as) {
		super();
		this.bs = bs;
		this.us = us;
		this.as = as;
	}
	
	@GetMapping
	public ResponseEntity<List<Beer>> getAllBeers(){
		return new ResponseEntity<>(bs.getAllBeers(),HttpStatus.OK);
	}
	
	
	
	

}

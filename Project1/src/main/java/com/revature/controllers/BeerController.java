package com.revature.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserNotFoundException;
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

	// Better practice to use class logger over root logger as we can specify
	// different logger configurations based on class
	private static Logger log = LoggerFactory.getLogger(BeerController.class);

	@Autowired
	public BeerController(BeerService bs, UserService us, AuthService as) {
		super();
		this.bs = bs;
		this.us = us;
		this.as = as;
	}

	@GetMapping
	public ResponseEntity<List<Beer>> getAllBeers() {
		log.info("HTTP Request for all beers");
		return new ResponseEntity<>(bs.getAllBeers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Beer> getById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<>(bs.getBeerbyId(id), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



	@PostMapping // Needs to be string to have entity print out
	public ResponseEntity<String> createBeer(@RequestBody Beer beer, @RequestHeader("Authorization") String token) {
		char idString = token.charAt(0);
		int id = Character.getNumericValue(idString);
//		if (token == null) {
		if (us.getUserById(id).equals(us.getUserById(1)) || us.getUserById(id).equals(us.getUserById(2))
				|| us.getUserById(id).equals(us.getUserById(4))) {
			Beer newBeer = bs.createBeer(beer);

			log.info("New beer " + newBeer.getBeerName() + " added to inventory by " + us.getUserById(id));
			return new ResponseEntity<>("New beer " + newBeer.getBeerName() + " added to inventory by employee",
					HttpStatus.CREATED);

		}
		log.warn("User: " + us.getUserById(id) + " without proper access attempted to add a beer.");
		return new ResponseEntity<>("You are not allowed, you are now being tracked by Craig.",
				HttpStatus.NOT_ACCEPTABLE);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBeer(@PathVariable("id") int beerId,
			@RequestHeader("Authorization") String token) {
		char idString = token.charAt(0);
		int userId = Character.getNumericValue(idString);
//		if (token == null) {
		if (us.getUserById(userId).equals(us.getUserById(1)) || us.getUserById(userId).equals(us.getUserById(2))
				|| us.getUserById(userId).equals(us.getUserById(4))) {
			log.info("Beer " + bs.getBeerbyId(beerId) + " has been removed from inventory " + us.getUserById(userId));
			bs.deleteBeerById(beerId);

			return new ResponseEntity<>("Beer  has been removed from inventory " + us.getUserById(userId),
					HttpStatus.OK);

		} else {
			log.warn("User: " + us.getUserById(userId) + " attempted to delete a beer");
			return new ResponseEntity<>("You are not allowed, you are now being tracked by Craig.",
					HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	@PutMapping
	public ResponseEntity<String> purchaseBeer(Beer beer){
		bs.updatebeer(beer);
		return new ResponseEntity<>("Beer bought", HttpStatus.OK);
	}

}

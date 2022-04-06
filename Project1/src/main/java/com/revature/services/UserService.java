package com.revature.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.BeerRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	private BeerRepository br;

	@Autowired
	public UserService(UserRepository ur, BeerRepository br) {
		super();
		this.ur = ur;
		this.br = br;
	}

	
	public List<User> getAllUsers() {
		return ur.findAll();
	}



}

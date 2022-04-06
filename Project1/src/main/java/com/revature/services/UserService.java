package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
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

	
	public List<UserDTO> getAllUsers() {
		List<User> users = ur.findAll();
		
		List<UserDTO> usersDTO = users.stream()
				.map((user) -> new UserDTO(user))
				.collect(Collectors.toList());
		return usersDTO;
	}
	



	public UserDTO getUserById(int id) throws UserNotFoundException {
		User user = ur.findById(id).orElseThrow(UserNotFoundException::new);
		return new UserDTO(user);
	}


}

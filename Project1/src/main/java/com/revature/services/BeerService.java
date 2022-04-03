package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Beer;

import com.revature.repositories.BeerRepository;
import com.revature.repositories.UserRepository;

@Service
public class BeerService {

//	public BeerService() {
//		super();
//		// TODO Auto-generated constructor stub
//	}




	private BeerRepository br;
	private UserRepository ur;



	@Autowired
	public BeerService(BeerRepository br, UserRepository ur) {
		super();
		this.br = br;
		this.ur = ur;
	}




	public List<Beer> getAllBeers() {
		return br.findAll();
	}

}

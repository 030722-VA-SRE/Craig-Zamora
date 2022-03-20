package com.revature.services;

import java.util.List;

import com.revature.daos.BeerDao;
import com.revature.daos.BeerPostgres;
import com.revature.models.Beer;

//Class is in charge of business logic
//Our service layer connects to our Doa layer

public class BeerServices {

	private BeerDao bd;

	public BeerServices() {
		bd = new BeerPostgres();
	}
	
	public List<Beer> getAll(){

	List<Beer> beers = bd.getAllBeers();

		
		return beers;
		
	}

	

}

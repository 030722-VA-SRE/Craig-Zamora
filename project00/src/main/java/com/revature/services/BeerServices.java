package com.revature.services;

import com.revature.daos.BeerDao;
import com.revature.daos.BeerPostgres;

//Class is in charge of business logic
//Our service layer connects to our Doa layer

public class BeerServices {

	private BeerDao id;

	public BeerServices() {
		id = new BeerPostgres();
	}
	
	
	

}

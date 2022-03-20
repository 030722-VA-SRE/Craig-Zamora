package com.revature.services;

import java.util.List;

import com.revature.daos.BeerDao;
import com.revature.daos.BeerPostgres;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Beer;

//Class is in charge of business logic
//Our service layer connects to our Doa layer

public class BeerServices {

	private BeerDao bd;

	public BeerServices() {
		bd = new BeerPostgres();
	}

	public List<Beer> getAll() {

		List<Beer> beers = bd.getAllBeers();

		return beers;

	}

	public Beer getById(int id) throws ItemNotFoundException {
		Beer beer = bd.getBeerById(id);

		if (beer == null) {
			throw new ItemNotFoundException();
			
		} else {

			return beer;
		}

	}
	
	public Beer getSpecific(int id, String name, double price, String type) {
		Beer beer = bd.getBeerSpecifiedValue(id, name, price, type);
		return beer;
	}

}

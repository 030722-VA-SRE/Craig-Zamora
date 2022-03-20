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

	public Beer getByName(String name) throws ItemNotFoundException {
		Beer beer = bd.getBeerByName(name);

		if (beer == null) {
			throw new ItemNotFoundException();

		} else {

			return beer;
		}
	}

	public List<Beer> getSpecific(double price, String type) throws ItemNotFoundException {

		List<Beer> beers = bd.getSpecificBeers(price, type);
		if (beers == null) {
			throw new ItemNotFoundException();

		} else {

			return beers;
		}
	}
	public void addBeer(Beer newBeer) {
		bd.addNewBeer(newBeer);
	}
	
	public void deleteById(int id) {
		bd.deleteBeerById(id);
	}
	
	public void updateById(Beer updatedBeer, int id) {
		bd.updateBeerById(updatedBeer, id);
	}

	public void reorderById() {
		bd.reorderBeersById();
	}

}

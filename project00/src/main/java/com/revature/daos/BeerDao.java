package com.revature.daos;

import java.util.List;

import com.revature.models.Beer;

public interface BeerDao {

	public Beer getBeerById(int id);
	public Beer getBeerByName(String name);
	public void addNewBeer(Beer newBeer);
	public void deleteBeerById(int id);
	public List<Beer> getAllBeers();
	public List<Beer> getSpecificBeers(double price, String type);
	public List<Beer> getBeerByPrice(double price);	
	public List<Beer> getBeerByType(String type);
	public List<Beer> getBeerByPriceAndType(double price, String type);

	void updateBeerById(Beer updatedBeer, int id);
	void reorderBeersById();



	
	
}

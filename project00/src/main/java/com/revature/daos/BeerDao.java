package com.revature.daos;

import java.util.List;

import com.revature.models.Beer;

public interface BeerDao {

	
	//method 

	
	public Beer getBeerById(int id);
	List<Beer> getAllBeers();
	
	
}

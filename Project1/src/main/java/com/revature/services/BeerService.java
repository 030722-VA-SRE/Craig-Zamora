package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Beer;
import com.revature.repositories.BeerRepository;
import com.revature.repositories.UserRepository;

@Service
public class BeerService {



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




	public Beer getBeerbyId(int id) throws UserNotFoundException {
		return br.findById(id).orElseThrow(UserNotFoundException::new);

	}



	@Transactional
	public Beer createBeer(Beer beer) {
		
		return br.save(beer);
	}



	@Transactional
	public void deleteBeerById(int beerId) {
		br.deleteById(beerId);
		
	}



	@Transactional
	public Beer updatebeer(Beer beer) {
		Beer b = br.findById(14).orElseThrow(UserNotFoundException::new);
		b.getBeerOwner().setId(beer.getBeerOwner().getId());
		return  br.save(beer);
	}









	

}

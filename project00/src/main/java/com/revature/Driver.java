package com.revature;

import com.revature.services.BeerServices;

import io.javalin.Javalin;

public class Driver {
	
	public static void main(String[] args) {
		BeerServices bs = new BeerServices();
		
		Javalin app = Javalin.create();
		app.start(8080);
		
		
	}


}

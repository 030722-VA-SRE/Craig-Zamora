package com.revature;


import com.revature.exceptions.ItemNotFoundException;
import com.revature.services.BeerServices;

import io.javalin.Javalin;

public class Driver {
	
	public static void main(String[] args) {
		BeerServices bs = new BeerServices();
		
		Javalin app = Javalin.create();
		app.start(8080);
		
		
		app.get("beers", (ctx) -> {  // beers/  is endpoint that gets all beers from database

	
			ctx.json(bs.getAll());
			ctx.status(200);
		});
		
		app.get("beers/{idSpecified}", (ctx) -> {  // beers{idSpecified} is endpoint that gets beer by specified id

			int id = Integer.parseInt(ctx.pathParam("idSpecified")); //Integer wraps primitive int into an object. parseInt parses a string arguement as an int. pathParam to get specific value in curly brackets

			try {
				ctx.json(bs.getById(id));
				ctx.status(200);
			} catch (ItemNotFoundException e){
				ctx.result("Beer " + id + " was not found or does not exist.");
				ctx.status(404);
				
			}

			
		});

		
	}


}


package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.revature.models.BeerClass;

import io.javalin.Javalin;

public class MainDriver {
	public static ArrayList<BeerClass> beerArray = new ArrayList<>();
	
	public static void main(String[] args) throws SQLException {

		Javalin app = Javalin.create((config) -> {
		});
		app.start(8080);

		app.get("Test", (ctx) -> {
			ctx.status(200);
			ctx.result("Test Passed!");
		});

		// To create array for sake of creating program

		BeerClass beer1 = new BeerClass("DosXX", true);
		BeerClass beer2 = new BeerClass("Truly", false);
		BeerClass beer3 = new BeerClass("Blood & Honey", true);

		beerArray.add(beer1);
		beerArray.add(beer3);
		beerArray.add(beer2);

		//INSERT CODE TO SORT ARRAY BEFORE PRINT
		
		
		System.out.println(Arrays.asList(beerArray));

		// ends here

		// Code to retrieve request for all items
		
		app.get("beers", (ctx) -> {
			
			ctx.status(200);
			ctx.json(beerArray);
		});

		// Code to retrieve request for specified endpoint to get specific item->
		// "/websocket/{path}"
		app.get("beers/{id}", (ctx) -> {

			BeerClass specificBeer = null;
			int id = Integer.parseInt(ctx.pathParam("id"));// extracts the id from the path param in the url, and
															// converts it to an int
			ctx.json("pathParam: " + ctx.pathParam("id")); // prints id path to verify for testing

			for (int i = 0; i < beerArray.size(); i++) {  //Array for going through array list and matching endpoint to item id
				if (beerArray.get(i).getId() == id) {
					specificBeer = beerArray.get(i);
				}
			}

			// to verify not bad address
			if (specificBeer == null) {

				ctx.status(404);
			} else {
				ctx.status(200);
				ctx.json(specificBeer);
			}
		});
		
		
		//Code to add information through user post
		app.post("beers/", (ctx) -> {
			BeerClass newItem = ctx.bodyAsClass(BeerClass.class);
			beerArray.add(newItem);
			//ctx.status(201);
		});
		


	}

}

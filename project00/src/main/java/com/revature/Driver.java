package com.revature;

import com.revature.exceptions.ItemNotFoundException;
import com.revature.services.BeerServices;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		BeerServices bs = new BeerServices();

		Javalin app = Javalin.create();
		app.start(8080);
		app.get("beers/{idSpecified}", (ctx) -> { // beers{idSpecified} is endpoint that gets beer by specified id

			int id = Integer.parseInt(ctx.pathParam("idSpecified")); // Integer wraps primitive int into an object.
																		// parseInt parses a string arguement as an int.
																		// pathParam to get specific value in curly
																		// brackets

			try {
				ctx.json(bs.getById(id));

				ctx.status(200);
			} catch (ItemNotFoundException e) {
				ctx.result("Beer " + id + " was not found or does not exist.");
				ctx.status(404);

			}

		});

		app.get("beers/*", (ctx) -> { // beers/ is endpoint that gets all beers from database
			String name = ctx.queryParam("name");
			String type = ctx.queryParam("type");
			String idString = ctx.queryParam("id");
			String priceString = ctx.queryParam("price");
			int id;
			double price;
			System.out.println("Name = " + name);
			System.out.println("type = " + type);
			System.out.println("id = " + idString);
			System.out.println("price = " + priceString);
			if (name == null && type == null && idString == null && priceString == null) {
				ctx.json(bs.getAll());
				ctx.status(200);
			} else {
				if (idString != null) {
					id = Integer.parseInt(ctx.queryParam("id"));
				} else {
					id = 0;
				}
				if (priceString != null) {
					price = Double.parseDouble(ctx.queryParam("price"));
					System.out.println("Double price =" + price);
				} else {
					price = 0;
				}

				ctx.json(bs.getSpecific(id, name, price, type));

			}

		});

	}

}

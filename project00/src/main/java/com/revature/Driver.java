package com.revature;

import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Beer;
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

			if (name == null && type == null && idString == null && priceString == null) {
				bs.reorderById();
				ctx.json(bs.getAll());
				ctx.status(200);
			} else if (idString != null && name == null && type == null && priceString == null) {
				id = Integer.parseInt(ctx.queryParam("id"));
				try {
					ctx.json(bs.getById(id));

					ctx.status(200);
				} catch (ItemNotFoundException e) {
					ctx.result("Beer " + id + " was not found or does not exist.");
					ctx.status(404);

				}

			} else if (idString == null && name != null && type == null && priceString == null) {

				try {
					ctx.json(bs.getByName(name));

					ctx.status(200);
				} catch (ItemNotFoundException e) {
					ctx.result("Beer " + name + " was not found or does not exist.");
					ctx.status(404);

				}
			} else {
				if (priceString != null) {
					price = Double.parseDouble(ctx.queryParam("price"));
				} else {
					price = 0;
				}

				if (bs.getSpecific(price, type) != null) {
					ctx.json(bs.getSpecific(price, type));
					ctx.status(200);
				} else {
					ctx.result("Specified beer was not found or does not exist.");
					ctx.status(404);

				}
			}
		});

		app.post("beers", (ctx) -> {
			Beer newBeer = ctx.bodyAsClass(Beer.class);
			bs.addBeer(newBeer);
			
			
		});
		
		app.delete("beers/{idSpecified}", (ctx) -> {
			int id = Integer.parseInt(ctx.pathParam("idSpecified"));
			bs.deleteById(id);
			
		});
		
		app.put("beers/{idSpecified}", (ctx) -> {
			int id = Integer.parseInt(ctx.pathParam("idSpecified"));
			Beer updatedBeer = ctx.bodyAsClass(Beer.class);
			bs.updateById(updatedBeer, id);
			
		});
		
		

	}
}

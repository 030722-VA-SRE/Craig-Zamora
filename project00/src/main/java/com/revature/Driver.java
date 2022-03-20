package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.services.BeerServices;
import com.revature.util.ConnectionUtil;

import io.javalin.Javalin;

public class Driver {
	
	public static void main(String[] args) {
		BeerServices bs = new BeerServices();
		
		Javalin app = Javalin.create();
		app.start(8080);
		
		
		app.get("beers", (ctx) -> {  // beers/  is endpoint that gets all beers from database
			
			ctx.json(null);
			ctx.status(200);
		});
		
		app.get("beers/{idSpecified}", (ctx) -> {  // beers{idSpecified} is endpoint that gets beer by specified id
			
			
		});
		try {
			Connection c = ConnectionUtil.getConnectionFromEnv();
			System.out.println("connection good");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}


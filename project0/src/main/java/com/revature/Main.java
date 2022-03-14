package com.revature;

import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create((config) -> {
		});
		app.start(8080);

		app.get("Test", (ctx) -> {
			ctx.status(200);
			ctx.result("Test Passed!");
		});

	}

}

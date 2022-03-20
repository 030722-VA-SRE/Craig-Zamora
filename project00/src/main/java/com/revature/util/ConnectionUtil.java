package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This class is a signleton as it is used for 1 purpose only: to be returned to any method querying the database
public class ConnectionUtil {

	private static Connection con; // we want the connection here and not in Postgres because we will need to reuse
									// the connection everytime we query (fetch it) for it.

	public static Connection getConnectionFromEnv() throws SQLException {
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");

		if (con == null || con.isClosed()) {

			con = DriverManager.getConnection(url, username, password);

		}
		return con;
	}

}

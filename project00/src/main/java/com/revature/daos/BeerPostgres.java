package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Beer;
import com.revature.util.ConnectionUtil;

public class BeerPostgres implements BeerDao {

	@Override
	public List<Beer> getAllBeers(int id, String name, String type) {
		String sql = "select * from beer;";
		List<Beer> beers = null;
		Beer beer = new Beer();
		// try with resources.
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql); // PreparedStatement lets you pass a precompiled sql
															// statement to object ps
			ResultSet rs = ps.executeQuery(); // ResultSet object (rs) maintains a cursor point to the current row of
												// data, usually executed by a query of database (ps in this case) (list
												// of all query results)

			while (rs.next()) {
				beer.setId(id);
				beer.setName(name);
				beer.setPrice(id);
				beer.setType(type);

				beers.add(beer);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return beers;
	}

	@Override
	public Beer getBeerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

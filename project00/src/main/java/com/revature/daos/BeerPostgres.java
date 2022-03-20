package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Beer;
import com.revature.util.ConnectionUtil;

public class BeerPostgres implements BeerDao {

	@Override
	public List<Beer> getAllBeers() {
		String sql = "select * from beer;";
		List<Beer> beers = new ArrayList<>();

		// try with resources.
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql); // PreparedStatement lets you pass a precompiled sql
															// statement to object ps
			ResultSet rs = ps.executeQuery(); // ResultSet object (rs) maintains a cursor point to the current row of
												// data, usually executed by a query of database (ps in this case) (list
												// of all query results)

			while (rs.next()) {
				Beer beer = new Beer(); // Need to reinstanciate beer as to not cause array to repeatedly populate last
										// value.
				beer.setId(rs.getInt("id"));
				beer.setName(rs.getString("beerName"));
				beer.setPrice(rs.getDouble("price"));
				beer.setType(rs.getString("beerType"));

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
		String sql = "select * from beer where id = ?"; // ? is a
		Beer beer = null;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id); // to set 1st question mark to value id - > i.e parameterizing the sql statement
								// with the id we are looking for.
			ResultSet rs = ps.executeQuery(); // ResultSet object (rs) maintains a cursor point to the current row of
												// data, usually executed by a query of database (ps in this case) (list
											// of all query results)

			if (rs.next()) {
				beer = new Beer();
				beer.setId(rs.getInt("id"));
				beer.setName(rs.getString("beerName"));
				beer.setPrice(rs.getDouble("price"));
				beer.setType(rs.getString("beerType"));
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return beer;
	}

	@Override
	public Beer getBeerSpecifiedValue() {
		// TODO Auto-generated method stub
		return null;
	}

}

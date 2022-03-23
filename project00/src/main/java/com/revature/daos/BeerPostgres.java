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
	public Beer getBeerByName(String name) {
		String sql = "select * from beer where beername = ?"; // ? is a
		Beer beer = null;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name); // to set 1st question mark to value id - > i.e parameterizing the sql statement
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
	public List<Beer> getSpecificBeers(double price, String type) {

		List<Beer> beers = new ArrayList<>();
		if (price != 0 && type == null) {
			beers = getBeerByPrice(price);
		} else if (price == 0 && type != null) {
			beers = getBeerByType(type);
		} else {
			beers = getBeerByPriceAndType(price, type);
		}
		return beers;
	}

	@Override
	public List<Beer> getBeerByPrice(double price) {
		String sql = "select * from beer where price = ?;";
		List<Beer> beers = new ArrayList<>();
		Beer beer = null;

		// try with resources.
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql); // PreparedStatement lets you pass a precompiled sql
															// statement to object ps
			ps.setDouble(1, price); // to set 1st question mark to value id - > i.e parameterizing the sql statement
			// with the id we are looking for.
			ResultSet rs = ps.executeQuery(); // ResultSet object (rs) maintains a cursor point to the current row of
												// data, usually executed by a query of database (ps in this case) (list
												// of all query results)

			while (rs.next()) {
				beer = new Beer(); // Need to reinstanciate beer as to not cause array to repeatedly populate last
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
	public List<Beer> getBeerByType(String type) {
		String sql = "select * from beer where beerType = ?;";
		List<Beer> beers = new ArrayList<>();

		// try with resources.
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql); // PreparedStatement lets you pass a precompiled sql
															// statement to object ps
			ps.setString(1, type); // to set 1st question mark to value id - > i.e parameterizing the sql statement
			// with the id we are looking for.
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
	public List<Beer> getBeerByPriceAndType(double price, String type) {
		String sql = "select * from beer where price = ? and  beerType = ?;";
		List<Beer> beers = new ArrayList<>();

		// try with resources.
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql); // PreparedStatement lets you pass a precompiled sql
															// statement to object ps
			ps.setDouble(1, price);
			ps.setString(2, type); // to set 1st question mark to value id - > i.e parameterizing the sql statement
			// with the id we are looking for.
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
	public void addNewBeer(Beer newBeer) {
		String sql = "insert into beer (beerName, price, beerType) values  (?,?, ?) returning id;";

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, newBeer.getName());
			ps.setDouble(2, newBeer.getPrice());
			ps.setString(3, newBeer.getType());
			ResultSet rs = ps.executeQuery(); // ResultSet object (rs) maintains a cursor point to the current row of
												// data, usually executed by a query of database (ps in this case) (list
												// of all query results)

//			if (rs.next()) {
//				beer = new Beer();
//				beer.setId(rs.getInt("id"));
//				beer.setName(rs.getString("beerName"));
//				beer.setPrice(rs.getDouble("price"));
//				beer.setType(rs.getString("beerType"));

			// check that the rows change is greater than zero.
//
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteBeerById(int id) {
		String sql = "delete from beer where id = ?";

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id); // to set 1st question mark to value id - > i.e parameterizing the sql statement
								// with the id we are looking for.
			ps.execute(); // executes prepared statement to delete item by id
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateBeerById(Beer updatedBeer, int id) {
		String sql = "update beer set beername = ? , price = ? , beertype = ? where id = ? ; ";
		String aSql = "select * from beer order by id asc;";

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			PreparedStatement as = c.prepareStatement(aSql);
			ps.setString(1, updatedBeer.getName());
			ps.setDouble(2, updatedBeer.getPrice());
			ps.setString(3, updatedBeer.getType());
			ps.setInt(4, id);

			ps.execute();
			as.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void reorderBeersById() {
		String sql = "select * from beer order by id asc;";

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

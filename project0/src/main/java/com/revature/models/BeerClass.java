package com.revature.models;

import java.util.Objects;
//TODO: Change class name Beer
public class BeerClass {

	private int id;
	private String beerName;
	private boolean isCompleted;
	public static int counter;

	public BeerClass() {
		super();
		// TODO Auto-generated constructor stub
		id = counter;
		counter++;
	}

//	
//	static int id;
//	
//	public ItemClass(){
//		name = "Item " + (id*Math.random());
//		price = 3 * id;
//		id++;
//	}
//	
	public BeerClass(String beerName, boolean isCompleted) {
		this();
		this.beerName = beerName;
		this.isCompleted = isCompleted;
	}

	public String toString() {
		return getBeerName() + " " + getId() + " " + isCompleted;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beerName, id, isCompleted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeerClass other = (BeerClass) obj;
		return Objects.equals(beerName, other.beerName) && id == other.id && isCompleted == other.isCompleted;
	}

}

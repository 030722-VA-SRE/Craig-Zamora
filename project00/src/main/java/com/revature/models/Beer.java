package com.revature.models;
//models have properties of things that we are working with. Item resources 

public class Beer {
	
	public Beer() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private double price;
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}

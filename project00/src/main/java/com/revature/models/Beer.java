package com.revature.models;
//models have properties of things that we are working with. Item resources 

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(type, other.type);
	}

}

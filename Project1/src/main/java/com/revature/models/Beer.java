package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "beers")
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String beerName;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private String type;
	@ManyToOne
	@JoinColumn(nullable = false, unique = true, name = "beer_owner_id")
	private User beerOwner;
	
	public Beer() {
		super();
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getBeerOwner() {
		return beerOwner;
	}

	public void setBeerOwner(User beerOwner) {
		this.beerOwner = beerOwner;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", beerName=" + beerName + ", price=" + price + ", type=" + type + ", beerOwner="
				+ beerOwner + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(beerName, beerOwner, id, price, type);
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
		return Objects.equals(beerName, other.beerName) && Objects.equals(beerOwner, other.beerOwner) && id == other.id
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(type, other.type);
	}


	
	

	
	
	

}

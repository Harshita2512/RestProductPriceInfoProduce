package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductPriceInfo {
	
	double price;
	int quantity;
	@Id
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

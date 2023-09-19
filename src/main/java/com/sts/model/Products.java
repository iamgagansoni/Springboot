package com.sts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float price;
	private String clas;
	private int currstock;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Products(int id, String name, float price, String clas, int currstock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.clas = clas;
		this.currstock = currstock;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCurrstock() {
		return currstock;
	}
	public void setCurrstock(int currstock) {
		this.currstock = currstock;
	}
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", clas=" + clas + ", currstock="
				+ currstock + "]";
	}

	
	
}

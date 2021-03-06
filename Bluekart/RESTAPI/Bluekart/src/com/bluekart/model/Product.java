package com.bluekart.model;

public class Product {
	
	private int ID;
	private String name;
	private String brand;
	private String type;
	
	public Product() 
	{

	}
	
	public Product(int iD, String name, String brand, String type) {
		super();
		ID = iD;
		this.name = name;
		this.brand = brand;
		this.type = type;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", brand=" + brand
				+ ", type=" + type + "]";
	}

}

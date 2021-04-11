package com.sahan.c3appone.model;

public class Car {
	
	private int id;
	private String model;
	private String brand;
	
	public Car() {
		
	}
	
	public Car(int id, String model, String brand) {
		setId(id);
		setModel(model);
		setBrand(brand);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	

}

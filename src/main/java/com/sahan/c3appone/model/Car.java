package com.sahan.c3appone.model;

public class Car {
	
	private int id;
	private String model;
	private String brand;
	private int year;
	private int user_id;
	
	public Car() {
		
	}
	
	public Car(int id, String model, String brand) {
		setId(id);
		setModel(model);
		setBrand(brand);
	}
	
	
	

	public Car(int id, String model, String brand, int year, int user_id) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.user_id = user_id;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}

package com.sahan.c3appone.dao;

import java.util.ArrayList;
import java.util.List;

import com.sahan.c3appone.model.Car;

public class CarDao {
	
	//Sample DB
	public List<Car> getFakeCarDB(){
		List<Car> carList = new ArrayList<>();
		
		Car car = new Car(1, "Axio", "Toyota");
		carList.add(car);
		carList.add(new Car(2, "A7", "Audi"));
		carList.add(new Car(3, "520D", "BMW"));
		
		return carList;
	}

}

package com.sahan.c3appone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sahan.c3appone.config.DbConnection;
import com.sahan.c3appone.model.Car;

public class CarDao {
	
	private Logger logger = LogManager.getLogger(CarDao.class);
	
	
	
	//Real Db
	
	public List<Car> getCarsFromDb(){
		
		List<Car> carList = new ArrayList<>(); 
		
		try {
			
		 Connection conn = DbConnection.getInstance().getConnection();
		 
		 String sql = "SELECT * FROM tbl_car";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			Car car = new Car();
			car.setId(rs.getInt("id"));
			car.setBrand(rs.getString("brand"));
			car.setModel(rs.getString("model"));
			car.setYear(rs.getInt("year"));
			car.setUser_id(rs.getInt("tbl_user_id"));
			
			carList.add(car);
		}
		 
			
		} catch (Exception e) {
			logger.error("DB Error "+e.getMessage());
		}
		
		return carList;
	}
	
	
	
	//Sample DB
	public List<Car> getFakeCarDB(){
		
		logger.trace("Cars has been accessed");
		
		
		List<Car> carList = new ArrayList<>();
		
		Car car = new Car(1, "Axio", "Toyota");
		carList.add(car);
		carList.add(new Car(2, "A7", "Audi"));
		carList.add(new Car(3, "520D", "BMW"));
		
		return carList;
	}
	
	

}

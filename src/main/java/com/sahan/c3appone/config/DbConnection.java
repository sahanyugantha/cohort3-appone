package com.sahan.c3appone.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.jdbc.Driver;
import com.sahan.c3appone.dao.CarDao;

public class DbConnection {
	private static Logger logger = LogManager.getLogger(DbConnection.class);

//	private static final String DB_URL = "jdbc:mysql://localhost:3306/cardb";
//	private static final String USER = "root";
//	private static final String PASSWORD = "root";
	
	//Heroku configs
	private static final String DB_URL = "jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_deda6a7c105921b";
	private static final String USER = "b1726dd3e646ca";
	private static final String PASSWORD = "c78da258";
	
	
	private static DbConnection newInstance = null;
	
	private DbConnection() {
		
	}
	
	public static DbConnection getInstance() {
		
		if (newInstance == null) {
			newInstance = new DbConnection();
		}
		return newInstance;
	}
	
	
	public Connection getConnection() {
				
		try {
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			return conn;
			
		} catch (Exception e) {
			logger.error("DB Error : "+e.getMessage());
			return null;
		}
	}

}

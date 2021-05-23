package com.sahan.c3appone;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.sahan.c3appone.dao.CarDao;
import com.sahan.c3appone.model.Car;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cars")
public class CarResource {
	
	private Logger logger = LogManager.getLogger(CarResource.class);

	@javax.ws.rs.GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCars() {
		
		logger.fatal("THIS IS A FATAL LOG"); // log message
		logger.error("THIS IS A ERROR LOG"); // log message
		logger.warn("THIS IS A WARN LOG"); // log message
		logger.info("THIS IS A INFO LOG"); // log message
		logger.debug("THIS IS A DEBUG LOG"); // log message
		logger.trace("THIS IS A TRACE LOG"); // log message
	
		
		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getCarsFromDb();
		
		Gson gson = new Gson(); //We can use Gson/Jackson etc.
		String jsonString = gson.toJson(cars);
		
		return jsonString; 
		
		//Logging
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getACar(@PathParam("id") int id) {
		
		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getFakeCarDB();
		
		Gson gson = new Gson();
		
		for (Car car : cars) {
			if(car.getId() == id) {
				String jsonString = gson.toJson(car);
				return jsonString;
			}
		}
		
		return "{message: N/A}"; // will be formatted.
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addCar() {
		return "Car successfully added!";
	}
	
	
}

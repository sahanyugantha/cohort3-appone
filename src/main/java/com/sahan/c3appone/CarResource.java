package com.sahan.c3appone;

import java.util.List;

import com.google.gson.Gson;
import com.sahan.c3appone.dao.CarDao;
import com.sahan.c3appone.model.Car;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("cars")
public class CarResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCars() {
		
		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getFakeCarData();
		
		Gson gson = new Gson(); //We can use Gson/Jackson etc.
		String jsonString = gson.toJson(cars);
		
		return jsonString; 
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getACar(@PathParam("id") int id) {
		return "Car with id "+id+" information will be here";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addCar() {
		return "Car successfully added!";
	}
	
	
}

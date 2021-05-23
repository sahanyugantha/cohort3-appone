package com.sahan.c3appone;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.sahan.c3appone.dao.UserDao;
import com.sahan.c3appone.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("u")
public class UserResource {
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userAuth(@FormParam("email") String email,
							@FormParam("password") String password) {
		
		Gson gson = new Gson();
		
		UserDao userDao = new UserDao();
		User user = userDao.login(email, password);
		
		if(user != null) {
		  String userJson =	gson.toJson(user);
			
			return Response
					.status(200)
					.entity(userJson)
					.build();
		} else {
			Map<String, String> errorMsg= new HashMap<>();
			errorMsg.put("ERROR", "INVALID EMAIL OR PASSWORD");
			
			String errorJson = gson.toJson(errorMsg);
			
			return Response
					.status(200)
					.entity(errorJson)
					.build();
			
			//If you need redirect to another place.
//			return Response
//					.seeOther(new URI("")) // this is for redirecting.
//					.build();
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(@FormParam("username") String username,
						@FormParam("email") String email,
						@FormParam("password") String password,
						@FormParam("role") String role) {
		
		Gson gson = new Gson();
		
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRole(role);
		
		UserDao userDao = new UserDao();
		int result = userDao.add(newUser);
		
		String message = "";
		
		if (result > 0) {
			Map<String, String> successMsg= new HashMap<>();
			successMsg.put("SUCCESS", "USER RECORD SUCCESSFULLY ADDED!");
			
			message = gson.toJson(successMsg);
		} else {
			Map<String, String> errorMsg= new HashMap<>();
			errorMsg.put("ERROR", "INVALID INPUTS");
			
			message = gson.toJson(errorMsg);
		}
		
		return Response
				.status(200)
				.entity(message)
				.build();
		
	}
	
	
	
}

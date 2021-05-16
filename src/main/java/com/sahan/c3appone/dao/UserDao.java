package com.sahan.c3appone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sahan.c3appone.config.DbConnection;
import com.sahan.c3appone.model.User;

public class UserDao {
	
	
	public User login(String email, String password) {
		
		
		try {
			Connection conn = DbConnection.getInstance().getConnection();
			
			String sql = "SELECT * FROM `tbl_user` WHERE `email`=? AND `password`=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs  = stmt.executeQuery();
			
			int rows = 0;
			User user = new User();
			
			while (rs.next()) {
				rows++;
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
						
			if(rows > 0)	{
				return user;
			} else {
				return null;
			}		
			
			
		} catch (Exception e) {

			e.printStackTrace();
			return null;
			
		}
		
	}
	
	
	public int add(User user) {
		try {
			Connection conn = DbConnection.getInstance().getConnection();
			String sql = "INSERT INTO tbl_user (`username`, `email`, `password`, `role`) VALUES (?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getRole());
			
			int res = stmt.executeUpdate();
			
			return res;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return -1;
		}
	}

}

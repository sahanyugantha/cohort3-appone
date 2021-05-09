package c3appone.sahan.c3appone.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.sahan.c3appone.config.DbConnection;

public class DbTest {
	
	//AAA approach
	
	DbConnection unexpected = null;
	
	
	@Test
	public void TestDb() {
		
		try {
			DbConnection actual = DbConnection.getInstance();
			
			assertNotEquals(unexpected, actual);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	int expected = 6;
	
	@Test
	public void TestDbCars() {
		
		try {
			
			Connection conn = DbConnection.getInstance().getConnection();
			
			String sql = "SELECT * FROM tbl_car";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			int rows = 0;
			while(rs.next()) {
				rows++;
			}
		
			assertEquals(expected, rows);
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}

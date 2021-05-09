package c3appone.sahan.c3appone.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sahan.c3appone.dao.CarDao;
import com.sahan.c3appone.model.Car;

public class CarTest {
	//Unit Test
	//AAA approach
	
	//Arrange
	int expected = 3;	
	//int actual = 0;
	
	//Act
	@Test
	public void testCarDao() {
		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getFakeCarDB();
		int actual = cars.size();
		
		//Assert
		assertEquals(expected, actual);
		 
	}


}

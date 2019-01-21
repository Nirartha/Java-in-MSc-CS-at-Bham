import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Ex1PublicTests {
	public static final double TOLERANCE = 0.00001;
	private Vehicle vehicle1, vehicle2;
	private Bus bus;
	
	@Before
	public void setUp() {
		
		vehicle1 = new Vehicle(15,87);
		bus = new Bus(100,200,50.3);
		vehicle2 = new Bus(210,150,56);
	}

	//testing getters of vehicle1
	@Test
	public void test1() {
		
		int expectedNumOfPassengers = 15;
		int actualNumOfPassengers = vehicle1.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 87;
		int actualMaxSpeed = vehicle1.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing getters of bus
	@Test
	public void test2() {
		
		int expectedNumOfPassengers = 100;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 200;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		double expectedFuelCons = 50.3;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	//testing setters of vehicle1
	@Test
	public void test3() {
		
		vehicle1.setPassengerNumber(43);
		int expectedNumOfPassengers = 43;
		int actualNumOfPassengers = vehicle1.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle1.setMaxSpeed(140);
		int expectedMaxSpeed = 140;
		int actualMaxSpeed = vehicle1.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing setters of bus
	@Test
	public void test4() {
		
		bus.setPassengerNumber(150);
		int expectedNumOfPassengers = 150;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		bus.setMaxSpeed(110);
		int expectedMaxSpeed = 110;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		
		bus.setFuelConsumption(47.2);
		double expectedFuelCons = 47.2;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	
	//testing getters of vehicle2
	@Test
	public void test5() {
		
		int expectedNumOfPassengers = 210;
		int actualNumOfPassengers = vehicle2.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 150;
		int actualMaxSpeed = vehicle2.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing setters of vehicle2
	@Test
	public void test6() {
		
		vehicle2.setPassengerNumber(180);
		int expectedNumOfPassengers = 180;
		int actualNumOfPassengers = vehicle2.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle2.setMaxSpeed(190);
		int expectedMaxSpeed = 190;
		int actualMaxSpeed = vehicle2.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
}

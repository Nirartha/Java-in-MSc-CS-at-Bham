package company;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Exercise1Tests {
	public static final double TOLERANCE = 0.00001;
	private Employee Employee1, Employee2;
	private ArrayList<Employee> payableObjects = new ArrayList<Employee>();
	
	@Before
	public void setUp() {
		
		Employee1 = new MonthlyEmployee("John", "Smith", "AA112312", 1800);
		Employee2 = new HourlyEmployee("Smith", "Mary", "AB 12346 C", 20);
		((HourlyEmployee) Employee2).setWorkedHoursLastMonth(180);
		
	}

	//testing getters of monthly/hourly payment
	@Test
	public void getPaymentAmountTest() {
		
		payableObjects.add(Employee1);
		payableObjects.add(Employee2);
		
		double expectedMonthlySalary = 1800;
		double actualMonthlySalary = ((MonthlyEmployee) Employee1).paymentAmount();
		assertEquals(expectedMonthlySalary, actualMonthlySalary, TOLERANCE);
		
		double expectedHourlySalary = 3600;
		double actualHourlySalary = ((HourlyEmployee) Employee2).paymentAmount();
		assertEquals(expectedHourlySalary, actualHourlySalary, TOLERANCE);
	}
	
	//testing setters of monthly/hourly payment
	@Test
	public void setMonthlyPayableTest() {
		
		((MonthlyEmployee) Employee1).setMonthlySalary(1900.01);
		((HourlyEmployee) Employee2).setHourlySalary(1234.56);
		
		payableObjects.add(Employee1);
		payableObjects.add(Employee2);
		
		double expectedMonthlySalary = 1900.01;
		double actualMonthlySalary = ((MonthlyEmployee) Employee1).getMonthlySalary();
		assertEquals(expectedMonthlySalary, actualMonthlySalary, TOLERANCE);
			
		double expectedHourlySalary = 1234.56;
		double actualHourlySalary = ((HourlyEmployee) Employee2).getHourlySalary();
		assertEquals(expectedHourlySalary, actualHourlySalary, TOLERANCE);
	}
	
	//testing getters of monthly/hourly increased payment
	@Test
	public void getIncreasedPayableTest() {

		payableObjects.add(Employee1);
		payableObjects.add(Employee2);
		
		Company company1 = new Company(payableObjects);
		company1.increaseSalaries(0.02);
		
		//Monthly
		double expectedMonthlySalary = 1836;
		double actualMonthlySalary = ((MonthlyEmployee) Employee1).getMonthlySalary();
		assertEquals(expectedMonthlySalary, actualMonthlySalary, TOLERANCE);
		
		double expectedMonthlyPaymentAmount = 1836;
		double actualMonthlyPaymentAmount = ((MonthlyEmployee) Employee1).paymentAmount();
		assertEquals(expectedMonthlyPaymentAmount, actualMonthlyPaymentAmount, TOLERANCE);
		
		//Hourly
		double expectedHourlySalary = 20.4;
		double actualHourlySalary = ((HourlyEmployee) Employee2).getHourlySalary();
		assertEquals(expectedHourlySalary, actualHourlySalary, TOLERANCE);
		
		double expectedHourlyPaymentAmount = 1836; //180 * 20.4
		double actualHourlyPaymentAmount = ((MonthlyEmployee) Employee1).paymentAmount();
		assertEquals(expectedHourlyPaymentAmount, actualHourlyPaymentAmount, TOLERANCE);
	}
}

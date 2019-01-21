import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	private Employee Dennis;
	private Employee Iris;
	private final static double TOLERANCE = 0.0001;

	@Before
	public void setup() {
		Dennis = new Employee("Dennis Chen", 80000, 20);
		Iris = new Employee("Iris Zheng", 55555, 40);
	}

	@Test
	public void test1_getDennis() {
		String expectedName = "Dennis Chen";
		double expectedTaxRate = 20;
		double expectedGrossSalary = 80000;
		double expectedNetSalary = 64000;

		String actualName = Dennis.getName();
		double actualTaxRate = Dennis.getTaxRate();
		double actualGrossSalary = Dennis.getMonthlyGrossSalary();
		double actualNetSalary = Dennis.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	@Test
	public void test2_getIris() {
		String expectedName = "Iris Zheng";
		double expectedTaxRate = 40;
		double expectedGrossSalary = 55555;
		double expectedNetSalary = 33333;

		String actualName = Iris.getName();
		double actualTaxRate = Iris.getTaxRate(); 
		double actualGrossSalary = Iris.getMonthlyGrossSalary();
		double actualNetSalary = Iris.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	@Test
	public void test3_Dennistax() {

		Dennis.setTaxRate(0);

		double expectedGrossSalary = 80000;
		double expectedNetSalary = 80000;

		double actualGrossSalary = Dennis.getMonthlyGrossSalary();
		double actualNetSalary = Dennis.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	@Test
	public void test4_Iristax() {

		Iris.setTaxRate(-40);

		double expectedGrossSalary = 55555;
		double expectedNetSalary = 77777;

		double actualGrossSalary = Iris.getMonthlyGrossSalary();
		double actualNetSalary = Iris.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	@Test
	public void test5_Iris() {

		Iris.setTaxRate(13.75);
		Iris.setMonthlyGrossSalary(67890);
		Iris.increaseSalary(9.9);
		
		double expectedGrossSalary = 74611.110;
		double expectedNetSalary = 64352.082;

		double actualGrossSalary = Iris.getMonthlyGrossSalary();
		double actualNetSalary = Iris.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);
		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}

}

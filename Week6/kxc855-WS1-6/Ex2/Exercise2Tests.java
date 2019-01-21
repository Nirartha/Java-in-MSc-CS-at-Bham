import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Exercise2Tests {

	public static final double TOLERANCE = 0.00001;

	private Measurable invoice1, invoice2, invoice3, invoice4, invoice5;
	private Measurable patient1, patient2, patient3, patient4, patient5;

	@Before
	public void setUp() {
		invoice1 = new Invoice("8657394", "56-42-45", 5450.25);
		invoice2 = new Invoice("2134564", "345-5-67", 3954.87);
		invoice3 = new Invoice("3456436", "15-46-58", 15456.83);
		invoice4 = new Invoice("241234", "25-46-53", 25465.14);
		invoice5 = new Invoice("4579300505", "12-54-545", 66666.666);

		patient1 = new Patient("Dennis", 54, 84.56);
		patient2 = new Patient("Jack", 24, 95.6);
		patient3 = new Patient("Iris", 44, 65.4);
		patient4 = new Patient("Kate", 57, 52.6);
		patient5 = new Patient("Amy", 39, 67.2);
	}

	// testing max on a list of invoices
	@Test
	public void maxInvoicesTest() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);
		invoiceList.add(invoice4);
		invoiceList.add(invoice5);

		double expectedMax = 66666.666;
		double actualMax = Statistics.maximum(invoiceList);

		assertEquals(expectedMax, actualMax, TOLERANCE);

	}

	// testing max on a list of patients
	@Test
	public void maxPatientsTest() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);

		double expectedMax = 95.6;
		double actualMax = Statistics.maximum(patientList);

		assertEquals(expectedMax, actualMax, TOLERANCE);
	}

	// testing average on a list of invoices
	@Test
	public void avgInvoicesTest() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);
		invoiceList.add(invoice4);
		invoiceList.add(invoice5);

		double expectedAvg = 23398.7512;
		double actualAvg = Statistics.average(invoiceList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}

	// testing standard deviation on a list of invoices
	@Test
	public void stdInvoicesTest() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);
		invoiceList.add(invoice4);
		invoiceList.add(invoice5);

		double expectedStd = 25688.8581768894;
		double actualStd = Statistics.standardDeviation(invoiceList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}

	// testing standard deviation on a list of patients
	@Test
	public void stdPatientsTest() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);

		double expectedStd = 16.97003;
		double actualStd = Statistics.standardDeviation(patientList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}

	// testing statistics on a list of invoices
	@Test
	public void invoicesTest() {
		Measurable invoice6 = new Invoice("56421541", "25-52-34", 5000.25);
		Measurable invoice7 = new Invoice("0556552", "35-23-14", 5000.25);
		Measurable invoice8 = new Invoice("5876542", "45-14-44", 5000.25);
		Measurable invoice9 = new Invoice("2357964", "56-32-24", 5000.25);

		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice6);
		invoiceList.add(invoice7);
		invoiceList.add(invoice8);
		invoiceList.add(invoice9);

		double expectedMax = 5000.25;
		double actualMax = Statistics.maximum(invoiceList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 5000.25;
		double actualAvg = Statistics.average(invoiceList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = 0;
		double actualStd = Statistics.standardDeviation(invoiceList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
	}
	
	// testing statistics on a list of patients
	@Test
	public void patientsTest() {
		
		Measurable patient6 = new Patient("Dennis", 54, 84.56);
		Measurable patient7 = new Patient("Jack", 24, 95.6);
		Measurable patient8 = new Patient("Iris", 44, 65.4);
		Measurable patient9 = new Patient("Kate", 57, 99.6);
		Measurable patient10 = new Patient("Amy", 39, 99.6);
		
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);
		patientList.add(patient5);
		patientList.add(patient6);
		patientList.add(patient7);
		patientList.add(patient8);
		patientList.add(patient9);
		patientList.add(patient10);

		double expectedMax = 99.6;
		double actualMax = Statistics.maximum(patientList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 79.75636;
		double actualAvg = Statistics.average(patientList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = 16.73539;
		double actualStd = Statistics.standardDeviation(patientList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
	}	
}

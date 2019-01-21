import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class StudentTests {
	
	public static final double TOLERANCE = 0.0001;
	
	// testing getters methods
	@Test
	public void TestGetters() {
        int[] tomMarks = {60, 50, 40, 70, 50, 70, 50, 40, 55, 50, 77, 67, -1, 100};
        Student tom = new Student("1234567", tomMarks);
        
        String expectedRegistrationNumber = "1234567";
        int[] expectedMarks = {60, 50, 40, 70, 50, 70, 50, 40, 55, 50, 77, 67, -1, 100};
        
        String actualRegistrationNumber = tom.getRegistrationNumber();
        int[] actualMarks = tom.getMarks();
        
        assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
        assertTrue(Arrays.equals(expectedMarks, actualMarks));     
	}
	
	// testing setters methods
	@Test
	public void TestSetters() {
        int[] irisMarks = {60, 50, 40, 70, 50, 70, 50, 40, 55, 50, 77, 67, -1, 100};
        Student iris = new Student("1222222", irisMarks);
        
        iris.setRegistrationNumber("1333333");
        iris.setAssignmentMark(4, 75);
        
        String expectedRegistrationNumber = "1333333";
        int[] expectedMarks = {60, 50, 40, 75, 50, 70, 50, 40, 55, 50, 77, 67, -1, 100};
        
        String actualRegistrationNumber = iris.getRegistrationNumber();
        int[] actualMarks = iris.getMarks();
        
        assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
        assertTrue(Arrays.equals(expectedMarks, actualMarks));     
	}
		
	// testing totalMark and passed
	@Test
	public void TestMarkAndPassed() {
		int[] dennisMarks = {50, 60, 70, 60, 75, 66, 77, 74, 70, 68, 78, 65, 69, 100};
		int[] amysMarks = {53, 60, 65, 67, 65, 75, 55, 66, 60, 70, 65, 45, 68, 64};
		int[] billsMarks = {-1, 60, -1, 60, 65, 70, 55, 66, 60, 73, 65, 45, 68, 94};
		int[] tobysMarks = {10, 80, 100, 100, 100, 88, 44, 100, 77, 100, 100, 100, -1, 35};
		
        Student dennis = new Student("1111111", dennisMarks);
        Student amy = new Student("2222222", amysMarks);
        Student bill = new Student("3333333", billsMarks);
        Student toby = new Student("4444444", tobysMarks);
        
        double expectedTotalMarkDennis = 90.1;
        double expectedTotalMarkAmy = 63.7;
        double expectedTotalMarkBill = 85.6;
        double expectedTotalMarkToby = 45.7;
        
        double actualTotalMarkDennis = dennis.totalMark();
        double actualTotalMarkAmy = amy.totalMark();
        double actualTotalMarkBill = bill.totalMark();
        double actualTotalMarkToby = toby.totalMark();
        
        assertEquals(expectedTotalMarkDennis, actualTotalMarkDennis, TOLERANCE);
        assertEquals(expectedTotalMarkAmy, actualTotalMarkAmy, TOLERANCE);
        assertEquals(expectedTotalMarkBill, actualTotalMarkBill, TOLERANCE);
        assertEquals(expectedTotalMarkToby, actualTotalMarkToby, TOLERANCE);
        
        assertTrue(dennis.passed());
        assertTrue(amy.passed());
        assertTrue(bill.passed());
        assertFalse(toby.passed());
	}
	
	// testing totalMark() return -1 when -1 weigh more than 50%
	@Test
	public void TestTotalMark() {
		
        int[] eddysMarks = {50, 60, -1, 60, 65, 70, 55, 66, 60, 73, 65, 99, -1, -1};
        Student eddy = new Student("6666666", eddysMarks);
        
        double expectedTotalMark = -1;
        
        double actualTotalMark = eddy.totalMark();
        
       assertEquals(expectedTotalMark, actualTotalMark, TOLERANCE);
		
	}
	
	// testing passed() throw new IllegalArgumentException when -1 weigh more than 50%
	@Test(expected = IllegalArgumentException.class)
	public void TestIllegalException() {
		
        int[] ericsMarks = {50, 60, -1, 60, 65, 70, 55, 66, 60, 73, 65, 45, -1, -1};
        Student eric = new Student("5555555", ericsMarks);
        
        // exception should be thrown
        eric.passed();
		
	}
	
}

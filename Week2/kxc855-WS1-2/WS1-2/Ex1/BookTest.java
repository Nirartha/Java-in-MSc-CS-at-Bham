import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private Book BestSeller2018A;
	private Book BestSeller2018B;
	
	@Before
	public void setup() {
		BestSeller2018A = new Book("The Girl in the Letter", 2018, "978-1-4722-5508-2");
		BestSeller2018B = new Book("Before We Were Yours", 2017, "978-0-4252-8468-1");
	}
	
	@Test
	public void test1_getTitle() {
		String expected = "The Girl in the Letter";
		String actual = BestSeller2018A.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2_getYear() {
		int expected = 2018;
		int actual = BestSeller2018A.getYear();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3_getISBN() {
		String expected = "978-1-4722-5508-2";
		String actual = BestSeller2018A.getIsbn();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4_setTitle() {
		BestSeller2018A.setTitle("Anna Karenina");
		String expected = "Anna Karenina";
		String actual = BestSeller2018A.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5_getTitle2() {
		String expected = "Before We Were Yours";
		String actual = BestSeller2018B.getTitle();
		assertEquals(expected, actual);
	}


}

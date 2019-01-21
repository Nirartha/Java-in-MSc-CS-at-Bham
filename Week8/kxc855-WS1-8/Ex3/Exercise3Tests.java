
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Exercise3Tests {
	public static final double TOLERANCE = 0.00001;
	Date nov22 = new Date(22, "November", 2018);
    Date nov23 = new Date(23, "November", 2018);
    
	@Before
	public void setUp() {
		/* test cases
        bookings2018.book("R222", nov22, 12, "Tutor meeting");
        bookings2018.book("R222", nov22, 12, "Java meeting"); //no booking since room booked already bookings2018.book("R222", nov22, 13, "Interviews");
        bookings2018.book("R222", nov23, 12, "Java meeting");
        bookings2018.book("R225", nov23, 20, "Java meeting"); //out of open time
        bookings2018.book("R111", nov23, 20, "Java meeting"); //out of open time
        bookings2018.book("R245", nov22, 16, "Project meeting");
        bookings2018.book("R225", nov22, 14, "Top-up tutorial");
        bookings2018.book("R225", nov22, 18, "Top-up tutorial"); //out of open time
        */
	}

	//testing available book
	@Test
	public void getAvailableBook() {
		
		String[] rooms = {"R217", "R222", "R225", "R245"};
		RoomBooking bookings2018 = new RoomBooking(2018, rooms);
		
		
		boolean expectedAvailableBook = true;
		boolean actualAvailableBook = bookings2018.book("R222", nov22, 12, "Tutor meeting");
		assertEquals(expectedAvailableBook, actualAvailableBook);
		
		boolean expectedAvailableBook1 = true;
		boolean actualAvailableBook1 = bookings2018.book("R222", nov23, 12, "Java meeting");
		assertEquals(expectedAvailableBook1, actualAvailableBook1);
		
		boolean expectedAvailableBook2 = true;
		boolean actualAvailableBook2 = bookings2018.book("R225", nov22, 14, "Top-up tutorial");
		assertEquals(expectedAvailableBook2, actualAvailableBook2);
	}
	
	//testing unavailable book, including wrong time, room
	@Test
	public void getUnavailableBook() {
		
		String[] rooms = {"R217", "R222", "R225", "R245"};
		RoomBooking bookings2018 = new RoomBooking(2018, rooms);
		
		
		boolean expectedUnavailableBook = false;
		boolean actualUnavailableBook = bookings2018.book("R222", nov22, 22, "Tutor meeting");
		assertEquals(expectedUnavailableBook, actualUnavailableBook);
		
		boolean expectedUnavailableBook1 = false;
		boolean actualUnavailableBook1 = bookings2018.book("R222", nov23, 6, "Java meeting");
		assertEquals(expectedUnavailableBook1, actualUnavailableBook1);
		
		boolean expectedUnavailableBook2 = false;
		boolean actualUnavailableBook2 = bookings2018.book("R111", nov22, 14, "Top-up tutorial");
		assertEquals(expectedUnavailableBook2, actualUnavailableBook2);
	}
	
	//testing re-book
	@Test
	public void getReBook() {
		
		String[] rooms = {"R217", "R222", "R225", "R245"};
		RoomBooking bookings2018 = new RoomBooking(2018, rooms);
		
		
		boolean expectedUnavailableBook = true;
		boolean actualUnavailableBook = bookings2018.book("R222", nov22, 12, "Tutor meeting");
		assertEquals(expectedUnavailableBook, actualUnavailableBook);
		
		boolean expectedUnavailableBook1 = false;
		boolean actualUnavailableBook1 = bookings2018.book("R222", nov22, 12, "Java meeting");
		assertEquals(expectedUnavailableBook1, actualUnavailableBook1);
	}
	
	//testing cancel and then re-book
	@Test
	public void cancelAndreBook() {
		
		String[] rooms = {"R217", "R222", "R225", "R245"};
		RoomBooking bookings2018 = new RoomBooking(2018, rooms);
		
		
		boolean expectedUnavailableBook = true;
		boolean actualUnavailableBook = bookings2018.book("R222", nov22, 12, "Tutor meeting");
		assertEquals(expectedUnavailableBook, actualUnavailableBook);
		
		bookings2018.cancel("R222", nov22, 12);
		
		boolean expectedUnavailableBook1 = true;
		boolean actualUnavailableBook1 = bookings2018.book("R222", nov22, 12, "Java meeting");
		assertEquals(expectedUnavailableBook1, actualUnavailableBook1);
	}
}

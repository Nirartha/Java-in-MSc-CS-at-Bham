import java.util.Arrays;
import java.util.Calendar;
import java.util.ArrayList;

public class RoomBooking {
	
	private ArrayList<RoomBooking> RoomBookingLists = new ArrayList<RoomBooking>();
	private final int[] businessTime = {9, 10, 11, 12, 13, 14, 15, 16, 17};
	
	private String[] rooms;
	private int year;
	private int hour;
	private Date date;
	private String room;
	private String purpose;
	
	/**
     *  Getter for the Rooms.
     *  @return The Rooms of the rooms is returned.
     */
	public String[] getRooms() {
		return rooms;
	}
	
	/**
     *  Setter for the Rooms. The Rooms of the Room is updated.
     *  @param Rooms The new Rooms of the updated Room.
     */
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}
	
	/**
     *  Getter for the Year.
     *  @return The Year of the rooms is returned.
     */
	public int getYear() {
		return year;
	}
	
	/**
     *  Setter for the Year. The Year of the Room is updated.
     *  @param Year The new Year of the updated Room.
     */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
     *  Getter for the Hour.
     *  @return The Hour of the rooms is returned.
     */
	public int getHour() {
		return hour;
	}
	
	/**
     *  Setter for the Hour. The Hour of the Room is updated.
     *  @param Hour The new Hour of the updated Room.
     */
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	/**
     *  Getter for the Date.
     *  @return The Date of the rooms is returned.
     */
	public Date getDate() {
		return date;
	}
	
	/**
     *  Setter for the Date. The Date of the Room is updated.
     *  @param Date The new Date of the updated Room.
     */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
     *  Getter for the Room.
     *  @return The Room of the rooms is returned.
     */
	public String getRoom() {
		return room;
	}
	
	/**
     *  Setter for the Room. The Room of the Room is updated.
     *  @param Room The new Room of the updated Room.
     */
	public void setRoom(String room) {
		this.room = room;
	}
	
	/**
     *  Getter for the Purpose.
     *  @return The Purpose of the rooms is returned.
     */
	public String getPurpose() {
		return purpose;
	}
	
	/**
     *  Setter for the Purpose. The Purpose of the Room is updated.
     *  @param Purpose The new Purpose of the updated Room.
     */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	/**
	 *  a constructor
     *  @param year The year of the room.
     *  @param rooms The lists of the room.
     */
	public RoomBooking (int year, String[] rooms) {
		this.year = year;
		this.rooms = rooms;
	}
	
	/**
     *  Display the date.
     *  @return The date of the room is returned.
     */
	public String displayDay(Date date) {
		String displayDay = "";
		String displayDate = "                                       " + date.toString() + "\n\n";
		String changeRowLine = "\n------+--------------------+--------------------+--------------------+--------------------+";
		String contentSpace = "                    ";
		String contentAdjust = "";
		
		//drawing a table
		displayDay += displayDate;
		displayDay += "      |";
		for (int j = 0; j < rooms.length; j++) {
			displayDay += "      " + rooms[j] + "          |";
		}
		displayDay += changeRowLine;
		
		
		for (int k = 0; k < businessTime.length; k++) {
			contentAdjust = contentSpace + businessTime[k] + ":00|";
			displayDay += "\n" + contentAdjust.substring(contentAdjust.length() - 7, contentAdjust.length());
			
			for (int i = 0; i < rooms.length; i++) {
				
				boolean emptyPurpose = true;
				for (int l = 0; l < RoomBookingLists.size(); l++) {
					if (RoomBookingLists.get(l).getRoom().equals(rooms[i]) && RoomBookingLists.get(l).getHour() == businessTime[k] && RoomBookingLists.get(l).getPurpose() != null && RoomBookingLists.get(l).getDate().equals(date)) {
						contentAdjust = contentSpace + RoomBookingLists.get(l).getPurpose() + "  |";
						displayDay += contentAdjust.substring(contentAdjust.length() - 21, contentAdjust.length());
						emptyPurpose = false;
					}
				}
				if (emptyPurpose) {
					displayDay += "                    |";
				}
			}
			displayDay += changeRowLine;
		}
		return displayDay;
	}
	
	/**
     *  Judge the room at the time could be booked or not
     *  @return true if the room could be booked
     *  @return false if the room could not be booked
     */
	public boolean book(String room, Date date, int hour, String purpose) {
		
		if (RoomBookingLists.size() == 0) {
			if (Arrays.binarySearch(rooms, room) > 0 && 9 <= hour && hour <= 17) {
				//Get current year
				Calendar cal = Calendar.getInstance();
				int newBookingYear = cal.get(Calendar.YEAR);
				RoomBooking newBooking = new RoomBooking (newBookingYear, rooms); //date.getYear
				newBooking.setRoom(room);
				newBooking.setDate(date);
				newBooking.setHour(hour);
				newBooking.setPurpose(purpose);
				RoomBookingLists.add(newBooking);
				return true;
			} else {
				return false;
			}
		} else {
			for (int i = 0; i < RoomBookingLists.size(); i++) {
				if (Arrays.binarySearch(rooms, room) > 0) {
				//if (RoomBookingLists.get(i).getRoom().equals(room)) {
					if (9 <= hour && hour <= 17) {
						if(RoomBookingLists.get(i).getDate().equals(date) && RoomBookingLists.get(i).getHour() == hour) {
							return false;
						} else {
							Calendar cal = Calendar.getInstance();
							int reBookingYear = cal.get(Calendar.YEAR);
							RoomBooking reBooking = new RoomBooking (reBookingYear, rooms); //date.getYear
							reBooking.setRoom(room);
							reBooking.setDate(date);
							reBooking.setHour(hour);
							reBooking.setPurpose(purpose);
							RoomBookingLists.add(reBooking);
							return true;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			return false;
		}
    }
	
	/**
     *  cancel the room which are already booked
     */
	public void cancel(String room, Date date, int hour) {
		for (int i = 0; i < RoomBookingLists.size(); i++) {
			if (Arrays.binarySearch(rooms, room) > 0) {
				if (9 <= hour && hour <= 17) {
					if(RoomBookingLists.get(i).getDate().equals(date) && RoomBookingLists.get(i).getHour() == hour) {
						RoomBookingLists.remove(i);
					}
				}
			}
		}
	}
	
	/**
     * @return A human readable description of the timetable in form of the table specifying it.
     */
	public String toString() {
		String toPrintString = "";
		toPrintString += "RoomBooking.toString(), year= " + year + ", String[] rooms= ";
		for (int i = 0; i < rooms.length; i++) {
			if (i == rooms.length - 1) {
				toPrintString += rooms[i] + ", ";
			} else {
				toPrintString += rooms[i];
			}
		}
		return toPrintString;
	}
}

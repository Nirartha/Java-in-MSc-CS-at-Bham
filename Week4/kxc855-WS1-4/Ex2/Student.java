public class Student {
	
	private String registrationNumber;
	private int[] marks = new int[14];

	/**
     *  Getter for the registrationNumber.
     *  @return The registrationNumber of the student is returned.
     */ 
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
     *  Getter for the marks.
     *  @return The marks of the student is returned.
     */ 
	public int[] getMarks() {
		return marks;
	}

	/**
     *  Setter for the registrationNumber. The registrationNumber of the student is updated.
     *  @param registrationNumber The new registrationNumber of the updated student.
     */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
     *  Setter for the marks. The marks of the student is updated.
     *  @param marks The new marks of the updated student.
     */
	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	/**
     *  @param reNumber The registrationNumber of the student.
     *  @param marks The marks array of the student.
     */
	public Student(String reNumber, int[] marks) {
		setRegistrationNumber(reNumber);
		setMarks(marks);
		totalMark();
	}

	/**
	 *  returns true if the total mark of the student is greater than or equal to 50 and false otherwise.
	 *  In the case of a total mark of -1, the method passed() should throw an IllegalArgumentException.
     *  @return throw new IllegalArgumentException, true or false
     */
	public boolean passed() {
		if(totalMark() == -1) {
			throw new IllegalArgumentException("There is an illegal argument exception");
		} else {
			return totalMark() > 50 ? true : false;
		}
	}

	/**
	 *  the percentage of 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 3, 10, 70
	 *  sams = should result in 56.5; billy = should result in 56.3
     *  Computes the total mark of a student, rounded to one decimal place.
     *  If a mark of -1 means the mark should be discarded from the computation of the total mark.
     *  If marks with a total weight of more than 50% of the total mark have been waived, then the returned total mark should be -1.
     *  @return -1 or total mark
     */
	public double totalMark() {
		int[] modulemark = {2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 3, 10, 70};
		double result = 0;
		double discardedScore = 0;

		for(int i = 0; i < marks.length; i++) {
			if(marks[i] == -1) {
				discardedScore += modulemark[i];
			} else {
				result += marks[i] * modulemark[i] * 10.0 / (100 * 10.0);
			}
		}
		
		return discardedScore >= 50 ? -1 : (Math.round(result * 100.0 / (100.0 - discardedScore) * 10.0)) / 10.0;
	}

	/**
     *  Setter a single assignment mark. The mark of the student is updated.
     *  @param assignmentNumber The assignmentNumber of mark will updated.
     *  assignmentNumberis to be a number between 1 and 14, representing the 14 component marks in the order presented above, each given out of 100.
     *  @param mark The new mark of the updated student.
     */
	public void setAssignmentMark(int assignmentNumber, int mark) {
		if(1 <= assignmentNumber && assignmentNumber <= 14) {
			marks[assignmentNumber - 1] = mark;
		}
	}

	/**
     * @return A human readable description of the student in form of the two field variables specifying it.
     */ 
	public String toString() {
		return "The student whose registrationNumber " + getRegistrationNumber() + "and get the total mark is " + getMarks();
	}
}
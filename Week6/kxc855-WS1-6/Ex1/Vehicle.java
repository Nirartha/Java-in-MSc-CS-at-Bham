public class Vehicle {
	
	private int passengerNumber;
	private int maxSpeed;
	
	/**
     *  Getter for the passengerNumber.
     *  @return The passengerNumber of the vehicle is returned.
     */
	public int getPassengerNumber() {
		return passengerNumber;
	}
	
	/**
     *  Getter for the maxSpeed.
     *  @return The maxSpeed of the vehicle is returned.
     */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
     *  Setter for the passengerNumber. The passengerNumber of the vehicle is updated.
     *  @param passengerNumber The new passengerNumber of the updated vehicle.
     */
	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	
	/**
     *  Setter for the maxSpeed. The maxSpeed of the vehicle is updated.
     *  @param maxSpeed The new maxSpeed of the updated vehicle.
     */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
     * @return A human readable description of the vehicle in form of the two field variables specifying it.
     */ 
	@Override
	public String toString() {
		return "Vehicle afford passenger capacities is " + passengerNumber + " and maxSpeed is " + maxSpeed;
	}
	
	/**
     *  @param passengerNumber The passengerNumber of the vehicle.
     *  @param maxSpeed The maxSpeed of the vehicle.
     */
	public Vehicle(int passengerNumber, int maxSpeed) {
		this.passengerNumber = passengerNumber;
		this.maxSpeed = maxSpeed;
	}
	
}

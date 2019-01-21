public class Bus extends Vehicle {
	
	private double fuelConsumption;
	
	/**
     *  Getter for the fuelConsumption.
     *  @return The fuelConsumption of the bus is returned.
     */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	
	/**
     *  Setter for the fuelConsumption. The fuelConsumption of the bus is updated.
     *  @param fuelConsumption The new fuelConsumption of the updated bus.
     */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	/**
     * @return A human readable description of the bus in form of the one field variable specifying it.
     */ 
	@Override
	public String toString() {
		return "The fuelConsumption of bus is " + fuelConsumption;
	}
	
	/**
	 *  extends Vehicle
     *  @param passengerNumber The passengerNumber of the vehicle.
     *  @param maxSpeed The maxSpeed of the vehicle.
     *  
     *  @param fuelConsumption The fuelConsumption of the bus.
     */
	public Bus(int passengerNumber, int maxSpeed, double fuelConsumption) {
		super(passengerNumber, maxSpeed);
		this.fuelConsumption = fuelConsumption;
	}
	
	
	
}

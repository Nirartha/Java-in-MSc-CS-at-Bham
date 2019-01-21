/**
 *  Kuanyow Chen
 *  1756755
 */
public class Employee {
	
	String name;
	double monthlyGrossSalary;
	double taxRate;

	/**
     *  Getter for the name.
     *  @return The name of the employee is returned.
     */ 
	public String getName() {
		return name;
	}

	/**
     *  Getter for the monthlyGrossSalary.
     *  @return The monthlyGrossSalary of the employee is returned.
     */ 
	public double getMonthlyGrossSalary() {
		return monthlyGrossSalary;
	}

	/**
     *  Getter for the taxRate.
     *  @return The taxRate of the employee is returned.
     */ 
	public double getTaxRate() {
		return taxRate;
	}

	/**
     *  Setter for the name. The name of the employee is updated.
     *  @param name The new name of the updated employee.
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     *  Setter for the MonthlyGrossSalary. The MonthlyGrossSalary of the employee is updated.
     *  @param setMonthlyGrossSalary The new MonthlyGrossSalary of the updated employee.
     */
	public void setMonthlyGrossSalary(double monthlyGrossSalary) {
		this.monthlyGrossSalary = monthlyGrossSalary;
	}

	/**
     *  Setter for the taxRate. The taxRate of the employee is updated.
     *  @param taxRate The new taxRate of the updated employee.
     */
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	/**
     *  Getter for the monthlyGrossSalary.
     *  @return The monthlyGrossSalary of the employee is returned.
     */ 
	public double getMonthlyNetSalary() {
		return monthlyGrossSalary * ((100 - this.taxRate) / 100.0);
	}

	/**
     *  Setter for the monthlyGrossSalary. The monthlyGrossSalary of the employee is updated.
     *  @param monthlyGrossSalary The new monthlyGrossSalary of the updated employee.
     */
	public void increaseSalary(double rate) {
		this.monthlyGrossSalary = monthlyGrossSalary * ((100.0 + rate) / 100.0);
	}

	/**
     * @return A human readable description of the employee in form
     *     of the three field variables specifying it.
     */ 
	public String toString() {
		double netMonthlyGrossSalary = monthlyGrossSalary * ((100 - this.taxRate) / 100.0);
		return getName() + " has a monthly gross salary of \u00a3" + Double.toString(getMonthlyGrossSalary()) + ", a taxrate of " + Double.toString(getTaxRate()) + "%, and a monthly net salary of \u00a3" + Double.toString(netMonthlyGrossSalary);
	}

	/**
     *  @param name The name of the employee.
     *  @param monthlyGrossSalary The monthlyGrossSalary of the employee.
     *  @param taxRate The taxRate of the employee.
     */
	public Employee(String name, double monthlyGrossSalary, double taxRate) {
		setName(name);
		setMonthlyGrossSalary(monthlyGrossSalary);
		setTaxRate(taxRate);
	}

	/*
     *  main method with a test of the create the new employee and
     *  toString method.
     */
	public static void main(String[] args) {
		Employee john = new Employee("John", 2400, 20);
		System.out.println(john);
		john.increaseSalary(1);
		System.out.println("After calling increaseSalary:\n" + john);
	}
	
}
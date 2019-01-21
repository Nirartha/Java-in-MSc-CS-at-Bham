package company;
import java.util.ArrayList;

public class Company {
	
	private ArrayList<Employee> employees;
	
	/**
     *  The constructor for a company with an ArrayList employees
     *  @param ArrayList<Employee> employees
     */
	public Company(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	/**
     *  getter for employees.
     *  @return The arrayList of the employee.
     */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	/**
     *  setter for employees.
     *  @param employees The detail of the employees.
     */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	/**
     *  A method to increase the original salary.
     *  new salary = original salary * (1 * rate)
     */
	public void increaseSalaries(double rate) {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i) instanceof MonthlyEmployee) {
				((MonthlyEmployee) employees.get(i)).setMonthlySalary(((MonthlyEmployee) employees.get(i)).getMonthlySalary() * (1 + rate));
			} else if (employees.get(i) instanceof HourlyEmployee) {
				((HourlyEmployee) employees.get(i)).setHourlySalary(((HourlyEmployee) employees.get(i)).getHourlySalary() * (1 + rate));
			}
		}
	}
}

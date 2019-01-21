import java.util.ArrayList;

/**
 * create the interface and a getValue method
 */
interface Measurable {
	public double getValue();
}

/**
 * class Invoice implements the interface and override a getValue method
 */
class Invoice implements Measurable {
	String accountNumber;
	String sortCode;
	double amount;
	
	public Invoice(String accountNumber, String sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}
	
	public double getValue() {
		return this.amount;
	}
}

/**
 * class Patient implements the interface and override a getValue method
 */
class Patient implements Measurable {
	String name;
	int age;
	double weight;
	
	public Patient(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public double getValue() {
		return this.weight;
	}
}

/**
 * class Statistics includes the maximum, average, and standardDeviation methods
 */
class Statistics {
	
	/**
	 * To get the maximum value in ArrayList.
	 * @return The maximum of the ArrayList.
	 */
	public static double maximum(ArrayList<Measurable> elements) {
		double maximum = elements.get(0).getValue();
		for (int i = 0; i < elements.size(); i++) {
			if (maximum < elements.get(i).getValue()) {
				maximum = elements.get(i).getValue();
			}
		}
		
		return maximum;
	}
	
	/**
	 * To get the average value in ArrayList.
	 * @return The average of the ArrayList.
	 */
	public static double average(ArrayList<Measurable> elements) {
		double sumElements = 0;
		
		for (int i = 0; i < elements.size(); i++) {
			sumElements += elements.get(i).getValue();
		}
		
		return sumElements/elements.size();
	}
	
	/**
	 * To get the standardDeviation value in ArrayList.
	 * @return The standardDeviation of the ArrayList.
	 */
	public static double standardDeviation(ArrayList<Measurable> elements) {
		double sumPowElements = 0;
		
		for (int i = 0; i < elements.size(); i++) {
			sumPowElements += Math.pow(elements.get(i).getValue() - average(elements), 2);
		}
		
		return Math.sqrt(sumPowElements/(elements.size()-1));
	}
	
}

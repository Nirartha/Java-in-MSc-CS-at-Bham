/*
 *  KUANYOW CHEN 1756755
 */
public class ConvertToKg {

	public static double imperialToKg(double ton, double hundredweight, double quarter, double stone, double pound, double ounce, double drachm, double grain) {
		return ((ton * 2240) + (hundredweight * 112) + (quarter * 28) + (stone * 14) + pound + (ounce * 1/16) + (drachm * 1/256) + (grain * 1/7000)) * 0.45359237;
	}

    public static void main(String[] args) {
    	System.out.println("A person's weight is " + imperialToKg(0, 0, 0, 11, 6, 0, 0, 0) + " Kg");
    }

}
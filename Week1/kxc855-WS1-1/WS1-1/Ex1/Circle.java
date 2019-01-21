/*
 *  KUANYOW CHEN 1756755
 */
public class Circle {

	public static double areaCircle(double radius) {
		return Math.PI * radius * radius;
	}

    public static void main(String[] args) {
    	System.out.println(areaCircle(0));
    	System.out.println(areaCircle(5));
    	System.out.println(areaCircle(10));
    }

}
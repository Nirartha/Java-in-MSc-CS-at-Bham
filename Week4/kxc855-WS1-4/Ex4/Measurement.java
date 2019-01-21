/**
 * It is not work because it will stop running when the method throw new IllegalArgumentException.
 * We should use try and catch to set the result when the method throw new IllegalArgumentException rather than throw it directly.
 * alter to use while loop and condition is res equal 0 to achieve the purpose that is to return two value 1 or 2.
 * (like the line 33 to 37)
 */



/** 
 *  The class firstly simulates a measurement performed by an
 *  instrument and that can take on two different values, 1 and 2. The
 *  instrument may also malfunction. We perform a series of
 *  measurments and store the values in the an array and print this
 *  out.
 *
 *  @version 2018-10-18
 *  @author Manfred Kerber
 */
public class Measurement {

    /**
     *  The method is used to simulate an instrument that randomly
     *  return either 1 or 2, or malfunctions.
     *  @return The method returns randomly either 1 or 2.
     *  @exception IllegalArgumentException if the instrument
     *  malfunctions. This is simulated only and done when a random
     *  number of 0 is created (out of numbers 0, 1, or 2).
     */
    public static int measurement() {
        //Create a random integer of either 0, 1, or 2.
        int res = (int) (Math.random() * 3);
        try {
        	if (res != 0) {
        		return res;
        	} else {
        		throw new IllegalArgumentException();
        	}
        } catch (IllegalArgumentException exception) {
            // Catch expected IllegalArgumentExceptions.
            return -1;
        }
    }
    

    /**
     *  The method stores the result of n measurements in an array and
     *  return this.
     *  @param n The number of measurements.
     *  @return An array with the result of n measurements being
     *  either 1 or 2. If the measurement failed, a -1 is stored in
     *  the array.
     *  @exception IllegalArgumentException if the result of the
     *  measurement is -1. */ 
    public static int[] measurementSeries(int n) {
        int[] result = new int[n];
        //Loop to do exactly n measurments
        for (int i = 0; i < n; i++) {
        	if (measurement() == -1) {
        		try {
        			result[i] = -1;
                } catch (IllegalArgumentException exception) {
                	throw new IllegalArgumentException();
                }
            }
            else {
                result[i] = measurement();
            }
        	
        }
        return result;
    }

    /**
     *  Print out the elements of a one-dimensional integer array,
     *  separated by empty spaces.
     *  @param a A one-dimensional int array.
     */
    public static void printArray(int[] a) {
        for (int el : a) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    /* 
     * Main method to test the program with 10 measurements.
     */
    public static void main(String[] args) {
        printArray(measurementSeries(10));
    }
}

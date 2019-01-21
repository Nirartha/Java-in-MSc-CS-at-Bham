/*
 *  KUANYOW CHEN 1756755
 *  main method: angle of hours + minutes + hours influenced by minutes + minutes influenced by seconds
 *  use % 12 to make user could type arbitrary hour
 *  use "(minutes / 2) + (minutes % 2)" to reach Math.round function
 *  use % 360 to avoid overing 360°
 *  use (int)double to keep the type of output
 *  (minutes / 60) * 30° = minutes / 2
 *  (seconds / 60) * 6° = seconds / 10
 */
public class ConvertTimeToAngle {
	
	public static int timeToAngle(int hours, int minutes, double seconds) {
		//(a) - ((hours % 12) * 30) + ((minutes / 2) + (minutes % 2)) + ((360 - (minutes * 6)) % 360); //(minutes / 60) * 30° = minutes / 2
		//(b) - (((hours % 12) * 30) + ((minutes / 2) + (minutes % 2)) + ((360 - (minutes * 6)) % 360)) % 360 + (int)(seconds / 10); //(seconds / 60) * 6° = seconds / 10
		//return (((hours % 12) * 30) + ((minutes / 2) + (minutes % 2)) + ((360 - (minutes * 6)) % 360)) % 360 + (int)(seconds / 10);
		return (((hours % 12) * 30) + ((minutes / 2) + (minutes % 2)) + ((360 - (minutes * 6)) % 360) + (360 - (int)(Math.round(seconds / 10) % 360))) % 360;
	}

	public static void main(String[] args) {
		//(a)
		System.out.println("Time is 9:00 and then the angle is " + timeToAngle(9, 00, 00) + "°");   //Sould be 270°
		System.out.println("Time is 3:00 and then the angle is " + timeToAngle(3, 00, 00) + "°");	//Sould be 90°
		System.out.println("Time is 18:00 and then the angle is " + timeToAngle(18, 00, 00) + "°"); //Sould be 180°
		System.out.println("Time is 1:00 and then the angle is " + timeToAngle(1, 00, 00) + "°");	//Sould be 30°
		System.out.println("Time is 2:30 and then the angle is " + timeToAngle(2, 30, 00) + "°");	//Sould be 255°
		System.out.println("Time is 4:41 and then the angle is " + timeToAngle(4, 41, 00) + "°");	//Sould be 255°
		//(b)
		System.out.println("Time is 0:00:20 and then the angle is " + timeToAngle(0, 00, 20) + "°"); //Sould be 358°
		System.out.println("Time is 13:05:27.272727272727 and then the angle is " + timeToAngle(13, 05, 27.272727272727) + "°"); //Sould be 0°
	}

}
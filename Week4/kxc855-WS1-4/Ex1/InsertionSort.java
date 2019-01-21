public class InsertionSort {
	
	/**
     * @return An order description of the array from smallest to biggest
     */ 
	public static int[] insertionSort(int[] numbers) {

		for(int i = numbers.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(numbers[j] > numbers[j + 1]) {
					//method i
					int tempelement = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tempelement;
					//Method ii
					//Swap(numbers, j, j + 1);
				}
			}
		}
		return numbers;
	}

	/** Method ii
	 *  in order to switch two elements in an array
     *  @param array The array of the numbers.
     *  @param i first element of the array.
     *  @param j second element of the array.
     */
	public static void Swap(int[] array, int i, int j) {
		int tempelement = array[i];
		array[i] = array[j];
		array[j] = tempelement;
	}

	/**
     * @return A human readable description of the student in form of the one field variables specifying it.
     */ 
	public static void ToString(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i < array.length - 1) {
				System.out.print(array[i] + ", ");
			} else {
				System.out.print(array[i]);
			}
			
		}
	}

}
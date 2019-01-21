public class Swap {
	/*
	 *  KUANYOW CHEN 1756755
	 *  swaps i and j
	 *  @pagram i 1st variable.
	 *  @pagram j 2nd variable.
	 */
	int i, j;

	public static void swap(int[] i, int[] j) {
			i[0] = i[0] ^ j[0];
			j[0] = i[0] ^ j[0];
			i[0] = i[0] ^ j[0];
		}

	public static void main(String[] args) {
		int[] i = {2};
		int[] j = {6};

		System.out.println("Original  i: " + i[0] + " j: " + j[0]);

		swap(i, j);
		System.out.println("After swapping  i: " + i[0] + " j: " + j[0]);
		}

}
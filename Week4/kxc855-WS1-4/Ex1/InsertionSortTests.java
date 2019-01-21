import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class InsertionSortTests {
	
	// testing larger array from unsorted to sorted
	@Test
	public void TestLargerArray() {
		int[] numbers = {56, 33, 101, 1, 76, 102, 765, 45, 98, 567};
		int[] expected = {1, 33, 45, 56, 76, 98, 101, 102, 567, 765};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on already sorted array to check the same as each other
	@Test
	public void TestSortedArray() {
		int[] numbers = {12, 23, 34, 45, 56, 67, 78, 89, 90};
		int[] expected = {12, 23, 34, 45, 56, 67, 78, 89, 90};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on array with same value
	@Test
	public void TestSameValueArray() {
		int[] numbers = {167, 333, 333, 167, 299, 425, 167};
		int[] expected = {167, 167, 167, 299, 333, 333, 425};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on empty array
	@Test
	public void TetsEmptyArray() {
		int[] numbers = {};
		int[] expected = {};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on array with negative numbers and same numbers
	@Test
	public void TestNegativeNum() {
		int[] numbers = {100, -2, -2, 444, 675, -96};
		int[] expected = {-96, -2, -2, 100, 444, 675};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}

}

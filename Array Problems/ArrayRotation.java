/*
 * @author Vinayak Nair$
 *
 */
public class ArrayRotation {

	/*
	 * Complexity: O(n*d)
	 */
	public static void rotateArray(int[] array, int d) {
		if (array.length == 0)
			return;
		while (d != 0) {
			int temp = array[0];
			for (int j = 1; j < array.length; j++) {
				array[j - 1] = array[j];
			}
			array[array.length - 1] = temp;
			d--;
		}
	}

	public static void rotateArrayUsingReversalAlgo(int[] array, int d) {

		/*
		 * Complexity: O(n) First reverse array up to d. Then reverse from d to length;
		 * Then reverse whole array;
		 */

		if (array.length == 0)
			return;
		reverseArray(array, 0, d - 1);
		reverseArray(array, d, array.length - 1);
		reverseArray(array, 0, array.length - 1);
	}

	private static void reverseArray(int[] array, int start, int end) {

		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

	public static void rotateArrayusingBlockSwap(int[] array, int i, int d, int n) {

		if (d == 0 || d == n)
			return;
		if (d == n - d) {
			swap(array, i, n - d + i, d);
			return;
		}
		if (d < n - d) {
			swap(array, i, n - d + i, d);
			rotateArrayusingBlockSwap(array, i, d, n - d);
		} else {
			swap(array, i, d, n - d);
			rotateArrayusingBlockSwap(array, n - d + i, 2 * d - n, d);
		}
	}

	private static void swap(int[] array, int firstBlock, int secondBlock, int d) {
		for (int i = 0; i < d; i++) {
			int temp = array[firstBlock + i];
			array[firstBlock + i] = array[secondBlock + i];
			array[secondBlock + i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int d = 3;
		// rotateArray(array, d % array.length);
		// rotateArrayUsingReversalAlgo(array, d % array.length);
		rotateArrayusingBlockSwap(array, 0, d, array.length);
		System.out.println("Rotated Array...");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}

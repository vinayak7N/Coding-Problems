/*
 * @author Vinayak Nair$
 *
 */
public class AlternatePositiveNegaitiveNumber {

	/*
	 * Given an array set alternate positive and negative number.
	 */
	public static void alternateArray(int[] array) {

		/*
		 * Stable algorithm do not changes elements relative position.
		 */
		if (array.length == 0)
			return;

		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			int k=i % 2;
			if (k == 0 && array[i] < 0) {

				while (j <= array.length - 1 && array[j] < 0) {
					j++;
				}
				if (j <= array.length - 1 && array[j] >= 0) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			} else if (k != 0 && array[i] >= 0) {

				while (j <= array.length - 1 && array[j] >= 0) {
					j++;
				}
				if (j <= array.length - 1 && array[j] <= 0) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}

	}

	public static void alternateArrayUsingPartition(int[] array) {

		/*
		 * Using Quicksort partition method. Partitioned array in negative and positive
		 * array. It changes elements relative position.
		 */

		if (array.length == 0)
			return;
		int i = -1, temp = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[j] < 0) {
				i++;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int posPos = i + 1, negPos = 0;
		while (posPos < array.length && negPos < posPos && array[negPos] < 0) {
			temp = array[posPos];
			array[posPos] = array[negPos];
			array[negPos] = temp;
			posPos++;
			negPos += 2;
		}
	}

	public static void main(String[] args) {
		int[] array = { -23, 9, -1, 2, -67, 34, -8, -2, 6, 5, -45, -67, -89, 90 };
		System.out.println("Alternate Array.....");
		alternateArray(array);
		// Output: 9 -23 2 -1 34 -67 6 -2 5 -8 90 -67 -89 -45
		// alternateArrayUsingPartition(array);
		// Output: 6 -1 5 -8 34 -45 2 -89 9 -67 90 -67 -23 -2
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}

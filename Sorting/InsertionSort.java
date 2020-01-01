/*
 * @author Vinayak Nair$
 *
 */
public class InsertionSort {

	public static int[] insertionSort(int[] array) {

		if (array.length == 0)
			return array;
		for (int i = 1; i < array.length; i++) {
			int v = array[i];
			int j = i;
			while (j >= 1 && array[j - 1] > v) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = v;
		}
		return array;
	}

	public static void main(String[] args) { 

		int[] array = { 10, 4, 43, 5, 57, 91, 45, 9, 7 };
		array = insertionSort(array);
		System.out.println("Sorted elements:");
		for (int i : array) {
			System.out.print(i + " ");
		}

	}
}

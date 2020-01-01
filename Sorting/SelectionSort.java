
/*
 * @author Vinayak Nair$
 *
 */
/*
 * Complexity: O(n^2)
 */
public class SelectionSort {

	public static int[] selectionSort(int[] array) {

		// Finding the minimum element and swapping it with current item.
		if (array.length == 0)
			return array;
		int min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (i != min) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}

	public static int[] selectionSortAnotherOtherway(int[] array) {

		// Finding the maximum element and swapping it with current item from last.
		if (array.length == 0)
			return array;
		int max = 0, n = array.length;
		for (int i = 0; i < n - 1; i++) {
			max = 0;
			for (int j = 1; j < n - i; j++) {
				if (array[j] > array[max]) {
					max = j;
				}
			}
			if (max != n - i - 1) {
				int temp = array[n - 1 - i];
				array[n - 1 - i] = array[max];
				array[max] = temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = { 10, 4, 43, 5, 57, 91, 45, 9, 7 };
		array = selectionSort(array);
	//	array = selectionSortAnotherOtherway(array);
		System.out.println("Sorted elements:");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}

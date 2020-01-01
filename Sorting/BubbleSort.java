/*
 * @author Vinayak Nair$
 *
 */
/*
 * Complexity: O(n^2)
 */
public class BubbleSort {

	public static int[] bubbleSort(int[] arr) {
		if (arr.length == 0)
			return null;
		long start = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Bubble Sort takes time: " + (end - start));
		return arr;
	}

	public static int[] bubbleSortImproved(int[] arr) {
		if (arr.length == 0)
			return null;
		boolean swapped = true;
		long start = System.currentTimeMillis();
		for (int i = 0; i < arr.length && swapped; i++) {
			swapped = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Improved Bubble Sort takes time: " + (end - start));

		return arr;
	}

	public static void main(String[] args) {

		int[] array = new int[1000];
		for (int i = 1; i < 1000; i++) {
			array[i] = 1 + (int) (Math.random() * (1000 - 1));
		}
		array = bubbleSort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}

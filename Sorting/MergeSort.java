

/*
 * @author Vinayak Nair$
 *
 */
public class MergeSort {

	public static void mergeSort(int[] array, int n) {

		if (n < 2)
			return;
		int mid = n / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[n - mid];
		for (int i = 0; i < mid; i++) {
			leftArray[i] = array[i];
		}
		for (int i = 0; i < n - mid; i++) {
			rightArray[i] = array[mid + i];
		}
		mergeSort(leftArray, mid);
		mergeSort(rightArray, n - mid);
		merge(array, leftArray, rightArray, mid, n - mid);
	}

	private static void merge(int[] array, int[] leftArray, int[] rightArray, int leftSize, int rightSize) {

		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {

			if (leftArray[i] <= rightArray[j]) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}
		while (i < leftSize) {
			array[k++] = leftArray[i++];
		}
		while (j < rightSize) {
			array[k++] = rightArray[j++];
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 1, 9, 23, 90, 2, 6, 7, -34, -12, 5 };
		mergeSort(array, array.length);
		System.out.println("Sorted Array........");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}

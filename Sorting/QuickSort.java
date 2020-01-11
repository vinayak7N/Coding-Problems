
/*
 * @author Vinayak Nair$
 *
 */
public class QuickSort {

	public static void quickSort(int[] array, int begin, int end) {
		if (begin < end) {
			int pi = partition(array, begin, end);
			quickSort(array, begin, pi - 1);
			quickSort(array, pi + 1, end);
		}
	}

	private static int partition(int[] array, int begin, int end) {
		int last = array[end];
		int i = begin - 1;
		for (int j = begin; j < end; j++) {
			if (array[j] <= last) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[end];
		array[end] = array[i + 1];
		array[i + 1] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		int[] array = { 12, 1, 34, 78, 9, 6, 67 };
		quickSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}

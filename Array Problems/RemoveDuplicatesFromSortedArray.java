import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @author Vinayak Nair$
 *
 */
public class RemoveDuplicatesFromSortedArray {
	/*
	 * Remove duplicate for sorted array in place and return new length without using another array.
	 *INCOMPLETE....................
	 */

	public static int[] removeDuplicates(int[] array) {
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			if(array[i]!=array[j]) {
				array[++j]=array[i];
			}
		}
		
		return array;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Array size:");
		int sizeOfArray = Integer.parseInt(br.readLine());
		System.out.println("Enter Array:");
		int[] array = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println("Array values:");
		array=removeDuplicates(array);
		for (int i : array) {
			System.out.print(i + " ");
		}

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.HashMap;

/*
 * @author Vinayak Nair$
 *
 */
public class TwoSum {
	/*
	 * Given an array of integers, return indices of two numbers such that they add
	 * up to a specific target.
	 */

	public static int[] twoSum(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] indicesArray = new int[2];
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(sum - arr[i])) {
				indicesArray[0] = map.get(sum - arr[i]);
				indicesArray[1] = i;
				break;
			} else {
				map.put(arr[i], i);
			}
		}
		return indicesArray;
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
		System.out.println("Enter Sum:");
		int sum = Integer.parseInt(br.readLine());
		array = twoSum(array, sum);
		System.out.println("Array indices:");
		for (int i : array) {
			System.out.print(i + " ");
		}

	}

}

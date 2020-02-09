import java.util.HashSet;

/*
 * @author Vinayak Nair$
 * UNCOMMITED-----------------
 */

public class ConsecutiveArraylength {

	public static int consecutiveArray(int[] array) {
		int max = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			set.add(i);
		}
		for (int i : set) {
			if (set.contains(i - 1)) {
				continue;
			}
			int length = 0;
			while (set.contains(i++)) {
				length++;
			}
			max = Math.max(max, length);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = { 4, 2, 1, 6, 5 };
		// int[] array={3,1,5,5};
		System.out.println("Length of longest consecutive elements: " + consecutiveArray(array));
	}

}

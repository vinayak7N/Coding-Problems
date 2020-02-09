
/*
 * @author Vinayak Nair$
 *
 */
public class FindLargestAndSmallestNumberInArray {

	public static int[] findLargestAndSmallestInGivenArray(int[] array) {
		if (array.length == 0)
			return null;
		int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
		for (int i : array) {
			if (i > largest) {
				largest = i;
			} 
			if (i < smallest) {
				smallest = i;
			}
		}
		return new int[] { largest, smallest };
	}

	public static void main(String[] args) {
		//int[] array = { 23, 57, 88, 12, 96, -7, -34, -6, 23, 81, 60, 37, 82, 77, -1, -34 };
		int[] array= {1,100,20,30,50};
		array = findLargestAndSmallestInGivenArray(array);
		System.out.println("Largest: " + array[0] + " Smallest: " + array[1]);
	}

}

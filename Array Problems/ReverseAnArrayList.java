import java.util.ArrayList;
import java.util.Collections;

/*
 * @author Vinayak Nair$
 *
 */
public class ReverseAnArrayList {

	public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> arrayList) {
		if (arrayList.size() == 0)
			return arrayList;
		System.out.println("Before reversing: " + arrayList);
		// 1-Using Built-in function
		// Collections.reverse(arrayList);

		// 2-By swapping up to half of list
		int size = arrayList.size();
		for (int i = 0; i < size / 2; i++) {
			int temp = arrayList.get(size - i - 1);
			arrayList.set(size - i - 1, arrayList.get(i));
			arrayList.set(i, temp);
		}
		return arrayList;

	}

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(12);
		arrayList.add(13);
		arrayList.add(14);
		arrayList.add(15);
		arrayList.add(16);
		arrayList.add(17);
		System.out.println("After reversing: " + reverseArrayList(arrayList));
	}

}

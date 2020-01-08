
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UniqueAnagramFromArray {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("cedo");
		list.add("code");
		list.add("anagram");
		list.add("aaba");
		list.add("baaa");
		list.add("ecod");
		list.add("ramgnaa");
		list = getAnagram(list);
		System.out.println("Unique Anagram from List....");
		System.out.println(list);
	}

	private static List<String> getAnagram(List<String> list) {
		List<String> anagramList = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String temp : list) {
			char[] charArray = temp.toCharArray();
			Arrays.sort(charArray);
			String k = String.valueOf(charArray);
			if (!map.containsKey(k)) {
				anagramList.add(temp);
				map.put(k, 0);
			}
		}

		return anagramList;
	}

}

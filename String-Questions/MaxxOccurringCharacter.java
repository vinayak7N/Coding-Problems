import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MaxxOccurringCharacter {

	static void findMaxOccurringCharacter(String string) {

		if (string.length() == 0)
			return;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < string.length(); i++) {
			String s = ("" + string.charAt(i)).trim();
			if (!s.isEmpty()) {
				if (map.get(s) != null) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
		}

		int maxValue = Collections.max(map.values());
		for (String key : map.keySet()) {
			if (map.get(key) == maxValue) {
				System.out.println(key + " repeated " + maxValue + " times!");
			}
		}
	}

	public static void main(String[] args) {
		String input = "Today is Monday";
		findMaxOccurringCharacter(input);
	}

}

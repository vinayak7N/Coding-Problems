
package com.string.problems;

import java.util.Collections;
import java.util.HashMap;

/*
 * @author vinayak.nair
 *
 */
public class HighestOccurenceOfCharacter {

	static char findHighestOccurringChar(String string) {
		if (string == null || string.isEmpty())
			return '0';
		HashMap<Character, Integer> map = new HashMap<>();

		for (int index = 0; index < string.length(); index++) {
			char ch = string.charAt(index);
			if (map.get(string.charAt(index)) != null) {
				int val = map.get(ch);
				map.put(ch, ++val);
			} else {
				map.put(ch, 1);
			}
		}
		int maxValue = Collections.max(map.values());
		for (Character ch : map.keySet()) {
			if (map.get(ch) == maxValue) {
				return ch;
			}
		}
		System.out.println(map);

		return '0';
	}

	public static void main(String[] args) {
		System.out.println(
				"Highest occurring character: " + findHighestOccurringChar("aaaaaaaaaaaaaaaaabbbbcddddeeeeee"));
	}

}

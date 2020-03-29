package com.string.problems;

import java.util.Arrays;
import java.util.HashMap;

/*
 * @author vinayak.nair
 *
 */
public class CheckAnagram {

	static boolean checkAnagram(String first, String second) {

		if (initialValidate(first, second)) {
			first = first.toLowerCase();
			second = second.toLowerCase();
			StringBuffer sb = new StringBuffer(second);

			for (int index = 0; index < first.length(); index++) {
				char ch = first.charAt(index);
				sb.deleteCharAt(sb.indexOf(ch + ""));
			}
			return sb.length() == 0;
		} else
			return false;
	}

	static boolean checkAnagramSecondWay(String first, String second) {

		if (initialValidate(first, second)) {
			first = first.toLowerCase();
			second = second.toLowerCase();
			char[] firstChar = first.toCharArray();
			char[] secondChar = second.toCharArray();
			Arrays.sort(firstChar);
			Arrays.sort(secondChar);

			for (int index = 0; index < first.length(); index++) {
				if (firstChar[index] != secondChar[index])
					return false;
			}
			return true;
		} else
			return false;
	}

	static boolean checkAnagramThirdWay(String first, String second) {

		if (initialValidate(first, second)) {
			first = first.toLowerCase();
			second = second.toLowerCase();
			char[] firstChar = first.toCharArray();
			char[] secondChar = second.toCharArray();
			int[] counter = new int[256];
			Arrays.fill(counter, 0);

			for (int index = 0; index < first.length(); index++) {
				counter[firstChar[index]]++;
				counter[secondChar[index]]--;
			}

			for (int index = 0; index < counter.length; index++) {
				if (counter[index] != 0)
					return false;
			}
			return true;
		} else
			return false;
	}

	static boolean checkAnagramFourthWay(String first, String second) {

		if (initialValidate(first, second)) {
			first = first.toLowerCase();
			second = second.toLowerCase();
			HashMap<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

			for (int index = 0; index < first.length(); index++) {
				char ch = first.charAt(index);
				if (map1.get(ch) != null) {
					int val = map1.get(ch);
					map1.put(ch, ++val);
				}
				map1.put(ch, 1);
			}
			for (int index = 0; index < second.length(); index++) {
				char ch = second.charAt(index);
				if (map2.get(ch) != null) {
					int val = map2.get(ch);
					map2.put(ch, ++val);
				}
				map2.put(ch, 1);
			}
			return map1.equals(map2);
		} else
			return false;
	}

	private static boolean initialValidate(String first, String second) {
		if (first.isEmpty() || second.isEmpty())
			return false;
		else if (first.length() != second.length())
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		System.out.println("First String: " + "listen" + "\n" + "Second String: " + "silent");
		System.out.println("Are both strings is anagram of each other " + checkAnagramFourthWay("listen", "silent"));
	}

}

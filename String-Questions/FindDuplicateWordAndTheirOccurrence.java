package com.string.problems;

import java.util.HashMap;

/*
 * @author vinayak.nair
 *
 */
public class FindDuplicateWordAndTheirOccurrence {

	static void duplicateWordsFinder(String string) {
		if (string == null || string.isEmpty())
			return;
		string = string.toLowerCase();
		String[] strArray = string.split(" ");
		HashMap<String, Integer> map = new HashMap<>();

		for (int index = 0; index < strArray.length; index++) {
			if (map.computeIfPresent(strArray[index], (key, value) -> ++value) == null) {
				map.put(strArray[index], 1);
			}
		}
		map.entrySet().stream().filter(e -> e.getValue() > 1)
				.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
	}

	public static void main(String[] args) {
		System.out.println("Found all duplicate words with their occurrence---");
		duplicateWordsFinder("Java is java and again it is java");
	}

}

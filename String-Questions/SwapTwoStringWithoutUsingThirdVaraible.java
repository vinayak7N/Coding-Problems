package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class SwapTwoStringWithoutUsingThirdVaraible {

	static void swapper(String first, String second) {
		if (first == null || second == null)
			return;
		if (first.equals(second))
			return;
		first = first + " " + second;
		second = first + " " + second;
		first = first.substring(first.indexOf(" ") + 1);
		second = second.substring(0, second.indexOf(first));
		System.out.println("\nAfter swap:\n" + "First: " + first + "\tSecond: " + second);
	}

	public static void main(String[] args) {
		System.out.println("Before swap:\n" + "First: Java" + "\tSecond: Python");
		swapper("Java", "Python");
	}

}

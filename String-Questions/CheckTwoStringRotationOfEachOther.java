package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class CheckTwoStringRotationOfEachOther {

	static boolean checkRotation(String first, String second) {

		if (first.length() == 0 || second.length() == 0)
			return false;
		if (first.length() != second.length())
			return false;
		first = first.toLowerCase();
		second = second.toLowerCase();
		int len = first.length() - 1;

		for (int i = 0; i <= len; i++) {
			if (first.charAt(i) != second.charAt(len - i)) {
				return false;
			}
		}

		return true;
	}

	static boolean checkRotationSecond(String first, String second) {

		if (first.length() == 0 || second.length() == 0)
			return false;
		if (first.length() != second.length())
			return false;
		first = first.toLowerCase();
		second = second.toLowerCase();

		StringBuffer sb = new StringBuffer(second);
		sb.reverse();
		if (!sb.toString().equals(first)) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// String[] string= {"XYZ","ZYX"};
		String[] string2 = { "Equal", "Lauqe" };
		System.out.println("First string: " + string2[0] + " Second string: " + string2[1]);
		System.out.println("Are two rotated string are equal: " + checkRotationSecond(string2[0], string2[1]));
	}

}

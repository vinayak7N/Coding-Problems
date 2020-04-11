package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class CheckGIvenStringCanBeDerivedByRotatingFirstOne {

	static boolean checkRotation(String first, String second) {
		
		if (first == null || second == null || first.isEmpty() || second.isEmpty())
			return false;
		if (second.length() > first.length())
			return false;
		if (first.equals(second))
			return true;

		StringBuilder sb = new StringBuilder(first);
		for (int index = 0; index < first.length(); index++) {
			char ch = sb.charAt(0);
			sb = sb.deleteCharAt(0);
			sb.append(ch);
			if (sb.toString().equals(second))
				return true;
		}
		return false;
	}

	static boolean checkRotationSecondWay(String first, String second) {
		
		if (first == null || second == null || first.isEmpty() || second.isEmpty())
			return false;
		if (second.length() > first.length())
			return false;
		if (first.equals(second))
			return true;

		first += first;
		if (first.indexOf(second) >= 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(
				"Is second string can be obtained after rotating first one " + checkRotationSecondWay("ABCD", "DAB"));
	}

}

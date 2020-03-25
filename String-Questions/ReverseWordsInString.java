package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class ReverseWordsInString {

	static String reverseWord(String givenString) {

		String[] stringSplitter = givenString.split(" ");
		String output = "";
		for (int index = stringSplitter.length - 1; index >= 0; index--) {
			output += stringSplitter[index] + " ";
		}
		return output;
	}

	static String reverseWordSecondWay(String givenString) {
		
		String output = "";
		String temp = "";
		for (int index = givenString.length() - 1; index >= 0; index--) {
			char ch = givenString.charAt(index);
			if (ch != ' ') {
				temp = ch + temp;
			} else {
				output += temp + ch;
				temp = "";
			}
		}
		output += temp;
		temp=null;
		return output;
	}

	public static void main(String[] args) {
		System.out.println("Before reversing: " + "Java is best");
		System.out.println("After reversing: " + reverseWordSecondWay("Java is best"));
	}

}

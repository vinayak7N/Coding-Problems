package com.string.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author vinayak.nair
 *
 */
public class CountWordsInString {

	static int wordCounter(String string) {
		if (string.isEmpty() || string == null)
			return 0;
		StringTokenizer tokenizer = new StringTokenizer(string);
		return tokenizer.countTokens();
	}

	static int wordCounterSecondWay(String string) {
		if (string.isEmpty() || string == null)
			return 0;
		int count = 0;
		char[] charArray = string.toCharArray();
		for (int index = 0; index < charArray.length; index++) {
			char ch = charArray[index];
			if (ch == ' ' || ch == '\n' || ch == '\t' || ch == ',')
				count++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String inputString = "";
//		System.out.println("Enter string");
//		String temp = br.readLine();
//		while (!temp.equals("end")) {
//			inputString = inputString + temp + "\n";
//			temp = br.readLine();
//		}
//		System.out.println("Numbers of words in input string: " + wordCounterSecondWay(inputString));
//		
		Object o=new String("Vinayak");
		System.out.println(o);
		String s=new String("AAA");
		Object o2=(Object)s;
		System.out.println(o2);
		StringBuilder sb=new StringBuilder(s);
		System.out.println(s.equals(sb));
	}

}

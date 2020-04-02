package com.string.problems;

import java.util.Stack;

/*
 * @author vinayak.nair
 *
 */

/*	Reverse String representation of arithmetic expression
	Input expression: 4*5+60
 */
public class ReverseStringExpression {

	static String reverseExpression(String string) {
		if (string.isEmpty() || string == null)
			return string;
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < string.length(); index++) {

			char ch = string.charAt(index);
			if (!(ch == '+' | ch == '-' | ch == '*' | ch == '/')) {
				sb.append(ch);
			} else {
				stack.push(sb.toString());
				stack.push(ch + "");
				sb = new StringBuilder();
			}
		}
		stack.push(sb.toString());
		sb = new StringBuilder();

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	static String reveseExpressionSecondWay(String string) {

		if (string.isEmpty() || string == null)
			return string;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (int index = string.length() - 1; index >= 0; index--) {
			char ch = string.charAt(index);
			if (!(ch == '+' | ch == '-' | ch == '*' | ch == '/')) {
				sb1.append(ch + "");
			} else {
				sb1.reverse();
				sb1.append(ch + "");
				sb2.append(sb1);
				sb1 = new StringBuilder();
			}
		}
		sb1.reverse();
		sb2.append(sb1);
		return sb2.toString();
	}

	public static void main(String[] args) {
		System.out.println("Original expression: " + "45*56+60");
		System.out.println("Reversed expression: " + reveseExpressionSecondWay("45*56+60"));
	}

}

package com.stack.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* Here is a program to convert infix to postfix expression.
* Some rules for conversion are:
*
* 1. Print operands as they arrive.
* 2. If stack is empty or contains a left parenthesis on top, push the incoming operator on stack.
* 3. If incoming symbol is '(' push it onto the stack.
* 4. If the incoming symbol is ')' pop the stack and print the operators unit left '(' is encountered; pop '(' as well but do not add it to result.
* 5. If the incoming symbol has higher precedence than the top of stack, push it onto the stack.
* 6. If the incoming symbol has lower precedence than the top of the stack, pop and print the top.Then test the incoming operator against the new top of stack.
* 7. If the incoming symbol has equal precedence with the top of the stack, use Associativity rule.
* 8. Associativity rule, If associativity is L-R, then pop and print the top of stack and push the incoming operator.
* 9. Associativity rule, If associativity is R-L, then push the incoming operator on to stack.
* 10. At the end of expression, pop and print all operator of stack.*/


public class InfixToPostfixConversionUsingStack {

    static int precedence(Character ch) {

        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    static boolean associativityForEqualPrecedence(char ch1, char ch2) {

        /*  Here, true represent L-R associativity and vice-versa.
         * */
        List<Character> charList = Arrays.asList('+', '-', '*', '/');
        return charList.contains(ch1) || charList.contains(ch2);    //Rule 8,9
    }

    private static String infixToPostfix(String exp) {

        if (exp == null || exp.isEmpty())
            return exp;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < exp.length(); index++) {
            char ch = exp.charAt(index);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);      //Rule 1
            } else if (ch == '(') {     //Rule 3
                stack.push(ch);
            } else if (ch == ')') {     //Rule 4
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty())
                    stack.pop();
                else { //For invalid expression...
                    System.out.println("Mismatched parenthesis....");
                    return null;
                }
            } else if (!stack.isEmpty()) {
                if (precedence(ch) > precedence(stack.peek())) {        //Rule 5
                    stack.push(ch);
                } else if (precedence(ch) < precedence(stack.peek())) {     //Rule 6

                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                } else {        //Rule 7
                    //Here operators are having equal precedence therefore associativity rules are applied...
                    if (associativityForEqualPrecedence(ch, stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            } else if (stack.isEmpty() || stack.peek() == '(') {        //Rule 2
                stack.push(ch);
            }
        }
        //For handling invalid expression...
        if (!stack.isEmpty() && stack.search('(') != -1) {
            System.out.println("Mismatched parenthesis...");
            return null;
        }
        if (!stack.isEmpty()) {     //Rule 10
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String[] exprArray = {
                "K+L-M*N+(O^P)*W/U/V*T+Q^J^A",
                "a+b*(c^d-e)^(f+g*h)-i",
                "((a+b-c)*d^e^f)/g",
                "1+2+3*5+(6+7)+8",
                "((a-b)/c)",
                "a*b-a*b+a*b",
                "(a*b"};

        for (int index = 0; index < exprArray.length; index++) {
            System.out.println("Infix Expression: " + exprArray[index]);
            System.out.println("Postfix Expression: " + infixToPostfix(exprArray[index]));
        }
    }
}
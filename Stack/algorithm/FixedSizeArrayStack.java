package com.stack.algorithm;

import java.util.EmptyStackException;

/*
 * @author Vinayak Nair$
 *
 */
public class FixedSizeArrayStack {

	int[] stack;
	int top = -1;
	int capacity;
	static final int DEFAULT_CAPACITY = 10;

	public FixedSizeArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public FixedSizeArrayStack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
	}

	public boolean isEmpty() {
		return top == -1 ? true : false;
	}

	public boolean isFull() {
		return top == capacity - 1 ? true : false;
	}

	public int peek() {
		if (!isEmpty()) {
			return stack[top];
		}
		throw new EmptyStackException();
	}

	public int pop() {
		int data;
		if (!isEmpty()) {
			data = stack[top];
			stack[top--] = Integer.MIN_VALUE;
			return data;
		}
		throw new EmptyStackException();
	}

	public void push(int data) {
		if (!isFull()) {
			stack[++top] = data;
		} else {
			throw new StackOverflowError("Stack is full. Insertion not possible...");
		}
	}

	public int size() {
		return top + 1;
	}
	public String toString() {
		String s="Stack: [";
		if(size()>0)
			s+=stack[0];
		if(size()>1) {
			for(int i=1;i<capacity;i++) {
				if(stack[i]>0)
				s+=","+stack[i];
			}
		}
		return s+"]";
	}

	public static void main(String[] args) {
		FixedSizeArrayStack stack = new FixedSizeArrayStack();
		System.out.println("Is stack Empty: " + stack.isEmpty());
		for (int i = 100; i < 110; i++) {
			stack.push(i);
		}
		System.out.println("Is stack full: " + stack.isFull());
		try {
		stack.push(12345);
		}catch(StackOverflowError e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Peek operation: "+stack.peek());
		System.out.println("Pop operation: "+stack.pop());
		System.out.println(stack);
	}

}

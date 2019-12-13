package vin.LinkedList;

import java.util.EmptyStackException;

public class StackUsingArray {

	int[] stack;
	int length;
	int top;

	public StackUsingArray() {
		stack=new int[5];
		length=0;
		top=-1;		
	}	
	public StackUsingArray(int size){
		stack=new int[size];
		length=0;
		top=-1;
	}
	
	public void push(int data){
		if(!isStackFull()){
			stack[++top]=data;
			length++;
		}else{
			throw new StackOverflowError();
		}
	}
	public boolean isStackFull(){
		return length==stack.length;
	}
	public int peek(){
		return stack[top];
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public int numberOfElements(){
		return length;
	}
	public int pop(){
		if(isEmpty())
			throw new EmptyStackException();
		int element=stack[top];
		top--;
		length--;
		return element;
	}
	public void displayStack(){
		for(int i=top;i>=0;i--){
			System.out.print(stack[i]+" ");
		}
	}
	public static void main(String[] args) {
		StackUsingArray myStack=new StackUsingArray(10);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		//myStack.push(10);
		myStack.displayStack();
		System.out.println(myStack.isEmpty());
		System.out.println(myStack.isStackFull());
		System.out.println(myStack.numberOfElements());
		System.out.println(myStack.peek());
		System.out.println(myStack.pop());
		myStack.displayStack();
	}

}

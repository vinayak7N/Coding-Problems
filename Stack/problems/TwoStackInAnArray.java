package problems;

import java.util.EmptyStackException;

public class TwoStackInAnArray {


    public static void main(String[] args) {
        TwoStack<Integer> integerTwoStack = new TwoStack<>(10);
        integerTwoStack.push1(10); // 4
        integerTwoStack.push2(60);
        integerTwoStack.push1(20); // 3
        integerTwoStack.push2(70);
        integerTwoStack.push1(30); // 2
        integerTwoStack.push2(80);
        integerTwoStack.push1(40); // 1
        integerTwoStack.push2(90);
        integerTwoStack.push1(50); // 0
        integerTwoStack.push2(100);
        integerTwoStack.displayTwoStack();
        System.out.println("\n pop1 called::" + integerTwoStack.pop1());
        System.out.println("\n pop2 called::" + integerTwoStack.pop2());
        integerTwoStack.displayTwoStack();
    }
}

class TwoStack<T> {

    T[] arrayStack;
    int size;
    int top1, top2;

    TwoStack(int size) {

        arrayStack = (T[]) new Object[size];
        this.size = size;
        top1 = size / 2;
        top2 = size / 2 - 1;
    }

    //Push elements to Stack1
    void push1(T value) {

        if (top1 > 0) {
            arrayStack[--top1] = value;
        } else throw new StackOverflowError("Stack1 is full...");
    }

    //Push elements to Stack2
    void push2(T value) {

        if (top2 < size - 1) {
            arrayStack[++top2] = value;
        } else throw new StackOverflowError("Stack2 is full...");
    }

    T pop1() {

        if (top1 > size / 2) {
            System.out.println("Stack1 is empty...");
            throw new EmptyStackException();
        }
        //Setting null to removed value
        T x = arrayStack[top1];
        arrayStack[top1] = null;
        top1++;
        return x;
    }

    T pop2() {

        if (top2 <= size / 2) {
            System.out.println("Stack1 is empty...");
            throw new EmptyStackException();
        }
        //Setting null to removed value
        T x = arrayStack[top2];
        arrayStack[top2] = null;
        top2--;
        return x;
    }

    public void displayTwoStack() {

        System.out.println("Displaying stack1...");
        int i = top1;
        while (i <= (size / 2) - 1) {
            if (arrayStack[i] != null)
                System.out.print(arrayStack[i] + "\t");
            i++;
        }

        System.out.println("\nDisplaying stack2...");
        i = top2;
        while (i >= size / 2) {
            if (arrayStack[i] != null)
                System.out.print(arrayStack[i] + "\t");
            i--;
        }
    }
}

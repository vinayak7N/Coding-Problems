import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    private final T[] array;
    private int top;

    public GenericArrayStack() {

        this.capacity = DEFAULT_CAPACITY;
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public GenericArrayStack(int capacity) {

        array = (T[]) new Object[capacity];
        top = -1;
        this.capacity = capacity;
    }

    public static void main(String[] args) {

        integerStack();
        stringStack();
    }

    public void push(T value) {

        if (isFull())
            throw new StackOverflowError("Stack is full...");
        array[++top] = value;
    }

    public T pop() {

        if (isEmpty())
            throw new EmptyStackException();
        return array[top--];
    }

    public T peek() {

        if (isEmpty())
            throw new EmptyStackException();
        return array[top];
    }

    public boolean isFull() {

        return top == array.length - 1;
    }

    public boolean isEmpty() {

        return top == -1;
    }

    @Override
    public String toString() {
        return "GenericArrayStack" + Arrays.toString(array);
    }

    private static void integerStack() {

        System.out.println("Integer stack............");
        GenericArrayStack<Integer> intStack = new GenericArrayStack<>(15);
        System.out.println("Empty Stack: " + intStack);
        System.out.println("Is stack full " + intStack.isFull() + ",\t Is stack empty " + intStack.isEmpty());
        System.out.println("Pushing elements in stack....");
        for (int i = 15; i >= 1; i--) {
            intStack.push((int) (Math.random() * (100 - i)));
        }
        System.out.println("Stack with data " + intStack);
        System.out.println("Last element in stack: " + intStack.peek());
        System.out.println("Popping element in stack: " + intStack.pop());
    }

    private static void stringStack() {

        System.out.println("String stack..........");
        GenericArrayStack<String> stringStack = new GenericArrayStack<>();
        System.out.println("Empty Stack: " + stringStack);
        System.out.println("Is stack full " + stringStack.isFull() + ",\t Is stack empty " + stringStack.isEmpty());
        System.out.println("Pushing elements in stack....");
        char ch = 'A';
        for (int i = 1; i <= 10; i++) {
            stringStack.push("" + (char) (ch + i));
        }
        System.out.println("Stack with data " + stringStack);
        System.out.println("Last element in stack: " + stringStack.peek());
        System.out.println("Popping element in stack: " + stringStack.pop());
    }
}

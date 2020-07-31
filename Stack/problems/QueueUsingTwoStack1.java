import java.util.Stack;

public class QueueUsingTwoStack1 {

    /* Here, Queue is implemented using two stack.
     * The enQueue operation is costly O(n) as it make sure the incoming element is always at the top of stack
     * by moving all elements in stack1 to stack2 and then add element to stack1 and get back all elements
     * from stack2
     * */

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue elements: " + queue.dequeue());
        System.out.println("Queue elements: " + queue.dequeue());
        System.out.println("Queue elements by peek: " + queue.peek());
        System.out.println("Queue elements: " + queue.dequeue());
    }

    static class Queue<T> {

        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        void enqueue(T element) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(element);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        T dequeue() {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                System.exit(0);
            }
            return stack1.pop();
        }

        T peek() {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                System.exit(0);
            }
            return stack1.peek();
        }
    }
}

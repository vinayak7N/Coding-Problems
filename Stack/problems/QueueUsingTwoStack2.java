import java.util.Stack;

public class QueueUsingTwoStack2 {

    /* Here, Queue is implemented using two stack.
     * The deQueue operation is costly O(n) as if stack2 is empty
     * then all elements are moved from stack1 to stack2 and top element is popped from stack2.
     * */

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue elements: " + queue.dequeue());
        System.out.println("Queue elements: " + queue.dequeue());
        System.out.println("Queue elements: " + queue.dequeue());
    }

    static class Queue<T> {

        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        void enqueue(T element) {

            stack1.push(element);
        }

        T dequeue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue is empty!");
                System.exit(0);
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }
}

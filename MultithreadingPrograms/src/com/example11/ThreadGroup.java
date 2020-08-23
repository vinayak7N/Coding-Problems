package example11;

public class ThreadGroup {

    public static void main(String[] args) {

        System.out.println("Main Thread group: " + Thread.currentThread().getThreadGroup());
        System.out.println("Main Thread group name: " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("Main Thread's parent: " + Thread.currentThread().getThreadGroup().getParent().getName());
    }
}

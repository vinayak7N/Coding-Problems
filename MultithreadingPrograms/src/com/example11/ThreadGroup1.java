package example11;

public class ThreadGroup1 {

    public static void main(String[] args) {

        System.out.println("Main Thread group: " + Thread.currentThread().getThreadGroup());
        System.out.println("Main Thread group name: " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("Main Thread's parent: " + Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println("Active threads: "+Thread.currentThread().getThreadGroup().activeCount());
        ThreadGroup threadGroup = new ThreadGroup("First-group");
        Thread t1 = new Thread(threadGroup,"Thread-1");
        Thread t2 = new Thread(threadGroup,"Thread-2");

        //After changing Max priority, still already declare threads t1,t2 won't change their priority.
        threadGroup.setMaxPriority(2);

        Thread t3 = new Thread(threadGroup,"Thread-3");
        System.out.println("Thread-1 priority: "+t1.getPriority());
        System.out.println("Thread-2 priority: "+t2.getPriority());
        System.out.println("Thread-3 priority: "+t3.getPriority());
        System.out.println("Max priority of threadGroup: "+threadGroup.getMaxPriority());

    }
}

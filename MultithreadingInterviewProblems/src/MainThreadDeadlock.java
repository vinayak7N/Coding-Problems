public class MainThreadDeadlock {

    /* Here, join() method is called by main thread on itself; which makes
     *  it wait for itself infinitely...*/

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread currently executing: " + Thread.currentThread());

        //Main thread waiting for itself infinitely
        Thread.currentThread().join();
        System.out.println("This won't print ever!!!");
    }
}

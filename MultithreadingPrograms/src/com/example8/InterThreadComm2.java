package example8;

public class InterThreadComm2 {

    public static void main(String[] args) throws InterruptedException {

        ThreadB threadB = new ThreadB();

        new Thread(threadB).start();

        /*Because of this statement, main thread go into sleeping state and child thread executes first,
        and when Main thread wakes up from sleeping and calls wait() method, but there is no child thread
        to notify it(as it is executed already) resulting in main thread waiting indefinitely...
        */
        Thread.sleep(10000);
        synchronized (threadB) {

            System.out.println("Main thread calling wait()...");
            threadB.wait();
            System.out.println("Main thread gets notified...");
            System.out.println("Total is: " + threadB.total);
        }

    }
}


class ThreadB implements Runnable {

    int total = 0;

    @Override
    public void run() {

        synchronized (this) {

            System.out.println("Child thread starts calculation...");
            for (int i = 1; i < 500; i++) {
                total += i;
            }
            System.out.println("Child thread gives notification...");
            this.notify();
        }
    }
}
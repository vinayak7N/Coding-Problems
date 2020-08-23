package example7;
public class InterThreadComm1 {

    public static void main(String[] args) throws InterruptedException {

        ThreadB threadB = new ThreadB();

        new Thread(threadB).start();

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
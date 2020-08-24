package example13;

import java.util.concurrent.locks.ReentrantLock;

/*  Here in, tryLock() is used in which if a lock on object is available then thread enters
    the if statement and other threads won't wait and continue other part of execution.
* */
public class ReentrantLock3 {

    public static void main(String[] args) {

        //Creation and execution of 5o threads

        for (int i = 1; i <= 50; i++) {
            new MyThreadTask("Thread-" + i).start();
        }
    }
}

class MyThreadTask extends Thread {

    static ReentrantLock reentrantLock = new ReentrantLock();

    MyThreadTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (reentrantLock.tryLock()) {

            System.out.println(Thread.currentThread().getName() + "\t" + "locked the object" +
                    " and performing thread safe operation...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + "\t" + "unable to lock the object" +
                    " and performing alternative operations...");
        }
    }
}

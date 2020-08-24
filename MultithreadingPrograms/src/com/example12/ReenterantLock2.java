package example12;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLock2 {

    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Dhoni");
        MyThread t2 = new MyThread(d, "Yuvraj");
        MyThread t3 = new MyThread(d, "Raina");
        MyThread t4 = new MyThread(d, "Kohli");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Display {

    ReentrantLock reentrantLock = new ReentrantLock();

    public void wish(String name) {

        //here Display object will be locked by thread and release after unlock() method is called...
        reentrantLock.lock();
        for (int i = 1; i <= 10; i++) {
            System.out.print("Good Morning: ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
        //here lock will be released so that resource could be available for other threads
        reentrantLock.unlock();
    }
}

class MyThread extends Thread {
    Display d;
    String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

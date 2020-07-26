package com.example1;

public class SupervisionExample {

    /* A simple implementation of multithreading, where 2 threads are executing in parallel */

    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();
        worker1.start();
        worker2.start();
    }
}

class Worker1 extends Thread {

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker1 is executing task: " + index);
        }
    }
}

class Worker2 extends Thread {

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker2 is executing task: " + index);
        }
    }
}
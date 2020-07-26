package com.example4;

import java.util.stream.IntStream;

public class SupervisionExampleUsingRunnable {

    /* Multithreading of 2 threads using Runnable interface */

    private static final int[] array = IntStream.rangeClosed(0, 5000).toArray();
    private static final int totalExpectedSum = IntStream.rangeClosed(0, 5000).sum();
    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {

        Worker1Parallel worker1Parallel = new Worker1Parallel(array);
        Worker2Parallel worker2Parallel = new Worker2Parallel(array);
        Thread thread1 = new Thread(worker1Parallel);
        Thread thread2 = new Thread(worker2Parallel);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Expected Result: " + totalExpectedSum);
        System.out.println("Total Sum: " + sum);
    }

    public static void add(int toAdd) {
        sum += toAdd;
    }
}

class Worker1Parallel implements Runnable {

    int[] array;
    int sum = 0;

    Worker1Parallel(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int index = 0; index < array.length / 2; index++) {
            sum += array[index];
        }
        SupervisionExampleUsingRunnable.add(sum);
    }
}

class Worker2Parallel implements Runnable {

    int[] array;
    int sum = 0;

    Worker2Parallel(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int index = array.length / 2; index < array.length; index++) {
            sum += array[index];
        }
        SupervisionExampleUsingRunnable.add(sum);
    }
}
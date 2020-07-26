package com.example4;

import java.util.stream.IntStream;

public class SupervisionExampleUsingRunnableAndLambda {

    /* Multithreading of 2 threads using Runnable interface and Lambda expression */

    private static final int[] array = IntStream.rangeClosed(0, 5000).toArray();
    private static final int totalExpectedSum = IntStream.rangeClosed(0, 5000).sum();
    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int index = 0; index < array.length / 2; index++) {
                add(array[index]);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int index = array.length / 2; index < array.length; index++) {
                add(array[index]);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Expected Result: " + totalExpectedSum);
        System.out.println("Total Sum: " + sum);
    }

    public synchronized static void add(int toAdd) {
        sum += toAdd;
    }
}

package com.example3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableExample {

    //Generate an array of numbers 0-5000 using stream
    private static final int[] array = IntStream.rangeClosed(0, 5000).toArray();
    private static final int expectedResult = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable1 = () -> {

            int sum = 0;
            for (int index = 0; index < array.length / 2; index++) {
                sum += index;
            }
            return sum;
        };
        Callable callable2 = () -> {

            int sum = 0;
            for (int index = array.length / 2; index < array.length; index++) {
                sum += index;
            }
            return sum;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable1, callable2);
        List<Future<Integer>> results = executorService.invokeAll(taskList);
        int k = 0;
        int sum = 0;
        for (Future<Integer> result : results) {
            sum += result.get();
            System.out.println("Sum of " + ++k + " is: " + result.get());
        }
        executorService.shutdown();
        System.out.println("Total sum from Callable: " + sum);
        System.out.println("Expected sum: " + expectedResult);
    }
}

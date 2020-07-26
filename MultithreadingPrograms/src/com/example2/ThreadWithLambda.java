package com.example2;

public class ThreadWithLambda {

    public static void main(String[] args) {

        //Traditional way

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int index = 1; index < 10; index++) {
                    sum += index;
                }
                System.out.println("Traditional Sum: " + sum);
            }
        };

        new Thread(runnable).start();

        //Using Lambda

        Runnable runnable1 = () -> {

            int sum = 0;
            for (int index = 1; index < 10; index++) {
                sum += index;
            }
            System.out.println("Lambda Sum: " + sum);
        };
        new Thread(runnable1).start();

        //Using Thread and Lambda

        new Thread(() -> {
            int sum = 0;
            for (int index = 1; index < 10; index++) {
                sum += index;
            }
            System.out.println("Thread with Lambda Sum: " + sum);
        }).start();
    }
}

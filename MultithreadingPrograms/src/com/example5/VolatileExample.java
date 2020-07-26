package com.example5;

public class VolatileExample {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int index = 0; index < 2000; index++) {
                System.out.println("Value of index in thread1 is " + index);
            }
            flag = true;
            System.out.println("flag in thread1 is: " + flag);
        }).start();

        new Thread(() -> {
            int index = 1;
            while (!flag) {
                ++index;
            }
            System.out.println("Value of index in thread2 is " + index);
            System.out.println("flag in thread2 is: " + flag);
        }).start();
    }
}

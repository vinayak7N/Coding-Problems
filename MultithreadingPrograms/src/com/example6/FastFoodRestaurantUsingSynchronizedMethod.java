package com.example6;

public class FastFoodRestaurantUsingSynchronizedMethod {

    private String lastClientName;
    private int totalBurgersSold;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        FastFoodRestaurantUsingSynchronizedMethod fastFoodRestaurant = new FastFoodRestaurantUsingSynchronizedMethod();

        Thread t1 = new Thread(() -> {
            fastFoodRestaurant.buyBurger("Amy");
        });
        Thread t2 = new Thread(() -> {
            fastFoodRestaurant.buyBurger("Jack");
        });
        Thread t3 = new Thread(() -> {
            fastFoodRestaurant.buyBurger("Jill");
        });
        Thread t4 = new Thread(() -> {
            fastFoodRestaurant.buyBurger("Dan");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Total burgers sold: " + fastFoodRestaurant.getTotalBurgersSold());
        System.out.println("Last client: " + fastFoodRestaurant.getLastClientName());
        System.out.println("Total time of execution in msec: " + (System.currentTimeMillis() - startTime));
    }

    //This method is synchronized to give correct output but taking more time to execute...
    public synchronized void buyBurger(String clientName) {

        burgerPreparationTIme();
        this.lastClientName = clientName;
        totalBurgersSold++;
        System.out.println("Burger sold to: " + clientName);
    }

    private void burgerPreparationTIme() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTotalBurgersSold() {
        return totalBurgersSold;
    }

    public String getLastClientName() {
        return lastClientName;
    }
}
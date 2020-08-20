public class StaticSynchronizedClassLevelLock {

    public static void main(String[] args) {

        /*  Here two display object locks are being held by two different thread. So, in this case if we use synchronized
            in wish() method, then two thread will execute it concurrently bcoz they are holding two different locks.
            To handle this, we need to make it static synchronized lock, which is a class level lock. in that case once
            a thread locks an object of class, no other thread can lock its object and had to wait...

        * */
        DisplayWish d = new DisplayWish();
        DisplayWish d1 = new DisplayWish();
        MyThreadWish t1 = new MyThreadWish(d, "Dhoni");
        MyThreadWish t2 = new MyThreadWish(d1, "Yuvraj");
        t1.start();
        t2.start();
    }
}

class DisplayWish {

    public static synchronized void wish1(String name) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            System.out.print("Good Morning: ");
            Thread.sleep(1000);
            System.out.println(name);
        }
    }
}

class MyThreadWish extends Thread {

    DisplayWish d;
    String name;

    MyThreadWish(DisplayWish d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            DisplayWish.wish1(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


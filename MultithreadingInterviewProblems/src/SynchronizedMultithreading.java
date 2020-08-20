public class SynchronizedMultithreading {


    /*  Here, multiple thread are accessing same display object in synchronized way.
     * */
    public static void main(String[] args) throws InterruptedException {
        Display1 d1 = new Display1();
        MyThread1 t1 = new MyThread1(d1, "Dhoni");
        MyThread1 t2 = new MyThread1(d1, "Yuvraj");
        MyThread1 t3 = new MyThread1(d1, "Kohli");
        MyThread1 t4 = new MyThread1(d1, "Raina");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

class Display1 {

    public synchronized void wish1(String name) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            System.out.print("Good Morning: ");
            Thread.sleep(1000);
            System.out.println(name);
        }
    }
}

class MyThread1 extends Thread {

    Display1 d1;
    String name;

    MyThread1(Display1 d1, String name) {
        this.d1 = d1;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            d1.wish1(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

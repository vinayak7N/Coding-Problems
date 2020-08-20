public class NonSynchronizedMultithreadingIssue {


    /*  Here, multiple thread are accessing same display object, resulting in data inconstancy
     * */
    public static void main(String[] args) throws InterruptedException {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Dhoni");
        MyThread t2 = new MyThread(d, "Yuvraj");
        t1.start();
        t2.start();
    }

}

class Display {

    public void wish(String name) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            System.out.print("Good Morning: ");
            Thread.sleep(1000);
            System.out.println(name);
        }
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
        try {
            d.wish(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

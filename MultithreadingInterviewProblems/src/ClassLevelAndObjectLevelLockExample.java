public class ClassLevelAndObjectLevelLockExample {

    /*  Here, in this program different type of Class level lock, object level lock are applied
        and multiple threads try to access methods of one class concurrently.
        m1--> Class level lock
        m2--> Class level lock
        m3--> synchronized lock
        m4--> class static method
        m5--> class instance method
        So, if one thread applies class level lock on static synchronized method then no other thread
        can lock that method or any other static synchronized method unless lock is released.
        But other methods like-> static method, synchronized method and instance method can be executed
        concurrently.
    * */
    public static void main(String[] args) {

        ThreadLockExample threadLockExample = new ThreadLockExample();
        ThreadM1 m1 = new ThreadM1(threadLockExample);
        ThreadM2 m2 = new ThreadM2(threadLockExample);
        ThreadM3 m3 = new ThreadM3(threadLockExample);
        ThreadM4 m4 = new ThreadM4(threadLockExample);
        ThreadM5 m5 = new ThreadM5(threadLockExample);
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
    }

}

class ThreadM1 extends Thread {

    ThreadLockExample lockExample;

    ThreadM1(ThreadLockExample threadLockExample) {
        this.lockExample = threadLockExample;
    }

    @Override
    public void run() {
        try {
            ThreadLockExample.m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadM2 extends Thread {

    ThreadLockExample lockExample;

    ThreadM2(ThreadLockExample threadLockExample) {
        this.lockExample = threadLockExample;
    }

    @Override
    public void run() {
        try {
            ThreadLockExample.m2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadM3 extends Thread {

    ThreadLockExample lockExample;

    ThreadM3(ThreadLockExample threadLockExample) {
        this.lockExample = threadLockExample;
    }

    @Override
    public void run() {
        try {
            lockExample.m3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadM4 extends Thread {

    ThreadLockExample lockExample;

    ThreadM4(ThreadLockExample threadLockExample) {
        this.lockExample = threadLockExample;
    }

    @Override
    public void run() {
        try {
            ThreadLockExample.m4();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadM5 extends Thread {

    ThreadLockExample lockExample;

    ThreadM5(ThreadLockExample threadLockExample) {
        this.lockExample = threadLockExample;
    }

    @Override
    public void run() {
        try {
            lockExample.m5();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadLockExample {

    public static synchronized void m1() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside m1.....");
            Thread.sleep(1000);
        }
    }

    public static synchronized void m2() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside m2.....");
            Thread.sleep(1000);
        }
    }

    public static void m4() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside m4.....");
            Thread.sleep(1000);
        }
    }

    public synchronized void m3() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside m3.....");
            Thread.sleep(1000);
        }
    }

    public void m5() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside m5.....");
            Thread.sleep(1000);
        }
    }
}
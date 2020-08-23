package example10;


/*  Here in, a simple example of Deadlock where in Thread-1 acquires lock on B's object and
    Thread-1 acquires lock on A's object. Now, each thread wants another thread lock to call
    last() method but no one is releasing it, resulting in deadlock situation...
* */
public class SimpleDeadlockExample extends Thread {

    A a = new A();
    B b = new B();


    public static void main(String[] args) {
        SimpleDeadlockExample threadDeadlock = new SimpleDeadlockExample();
        threadDeadlock.threadStarter();
    }

    public void threadStarter() {

        this.start(); //Child thread starts here...
        a.m1(b);    //This line is executed by main thread...
    }

    @Override
    public void run() {

        b.m1(a); // this line is executed by child thread...
    }
}


class A {

    public synchronized void m1(B b) {
        System.out.println("Thread-1 start executing A's m1...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread-1 calling B's last method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A's last method...");
    }
}

class B {

    public synchronized void m1(A a) {
        System.out.println("Thread-2 start executing B's m1...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread-2 calling A's last method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B's last method...");
    }
}
package example16;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo2 {

    /*Here in, multiple threads running concurrently have their local Customer Id value*/

    public static void main(String[] args) {

        CustomerThread c1 = new CustomerThread("Customer-1");
        CustomerThread c2 = new CustomerThread("Customer-2");
        CustomerThread c3 = new CustomerThread("Customer-3");
        c1.start();
        c2.start();
        c3.start();

    }
}

class CustomerThread extends Thread {

    static AtomicInteger custId = new AtomicInteger(1);
    private static final ThreadLocal t1 = new ThreadLocal() {

        protected Integer initialValue() {
            return custId.getAndIncrement();
        }
    };

    CustomerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is having " +
                "customer Id: " + t1.get());
    }
}


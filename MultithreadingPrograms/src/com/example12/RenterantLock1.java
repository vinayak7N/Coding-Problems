package example12;

import java.util.concurrent.locks.ReentrantLock;

public class RenterantLock1 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.lock();
        System.out.println("Is locked: " + reentrantLock.isLocked());
        System.out.println("locked by main thread: " + reentrantLock.isHeldByCurrentThread());
        System.out.println("Threads waiting for this lock: " + reentrantLock.getQueueLength());
        reentrantLock.unlock();
        System.out.println("Main thread lock hold count: " + reentrantLock.getHoldCount());
        System.out.println("Is locked: " + reentrantLock.isLocked());
        reentrantLock.unlock();
        System.out.println("Is locked: " + reentrantLock.isLocked());
        System.out.println("Fair locking: " + reentrantLock.isFair());
    }
}

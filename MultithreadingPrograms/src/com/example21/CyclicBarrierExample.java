package example21;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new AfterBarAction());

		System.out.println("Starting all threads...");

		new MyThread(cyclicBarrier, "Thread-A");
		new MyThread(cyclicBarrier, "Thread-B");
		new MyThread(cyclicBarrier, "Thread-C");
	}

}

class MyThread implements Runnable {

	CyclicBarrier cyclicBarrier;
	String threadName;

	MyThread(CyclicBarrier cyclicBarrier, String threadName) {
		this.cyclicBarrier = cyclicBarrier;
		this.threadName = threadName;
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println("Started:" + threadName);
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(threadName + " has value " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(threadName + " has reached barrier will wait...");

			// All threads perform their action upto this point and will go to wait waiting
			// state...
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		// This line will execute only after AfterBarAction has completed its task...
		System.out.println(threadName + " execution completes...");
	}
}

// This task will be executed only after all threads reached CyclicBarrier i.e. cyclicBarrier.await() method...

class AfterBarAction implements Runnable {

	@Override
	public void run() {
		System.out.println("End of barrier reached...");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("AfterBarAction: " + i);
		}
	}
}

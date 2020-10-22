package example23;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

	public static void main(String[] args) {

		CountDownLatch countDownLatch1 = new CountDownLatch(5);
		CountDownLatch countDownLatch2 = new CountDownLatch(5);
		CountDownLatch countDownLatch3 = new CountDownLatch(5);
		CountDownLatch countDownLatch4 = new CountDownLatch(5);
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		System.out.println("Main thread started...");

		executorService.execute(new MyThread(countDownLatch1, "Thread-A"));
		executorService.execute(new MyThread(countDownLatch2, "Thread-B"));
		executorService.execute(new MyThread(countDownLatch3, "Thread-C"));
		executorService.execute(new MyThread(countDownLatch4, "Thread-D"));

		try {

			countDownLatch1.await();
			countDownLatch2.await();
			countDownLatch3.await();
			countDownLatch4.await();

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		executorService.shutdown();
		System.out.println("Work completed!");
	}

}

class MyThread implements Runnable {

	CountDownLatch countDownLatch;
	String threadName;

	MyThread(CountDownLatch countDownLatch, String threadName) {
		this.countDownLatch = countDownLatch;
		this.threadName = threadName;
		new Thread(this);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(threadName + " " + i);
			countDownLatch.countDown();
		}
	}
}

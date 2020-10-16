package example20;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(20);

		System.out.println("Starting...");

		new MyThread(countDownLatch);
		new SecondThread(countDownLatch);
		try {
			System.out.println("Main thread is going to wait for MyThread...");
			countDownLatch.await();
			System.out.println("Main thread wait is over...");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Execution completes...");
	}

}

class MyThread implements Runnable {

	private CountDownLatch countDownLatch;

	MyThread(CountDownLatch countDownLatch) {

		this.countDownLatch = countDownLatch;
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println("MyThread execution started with count down of 10 events...");

		for (int i = 0; i < 10; i++) {
			System.out.println("MyThread count is " + i);
			countDownLatch.countDown();
		}
		System.out.println("MyThread CountDown is completed....");
	}

}

class SecondThread implements Runnable {

	private CountDownLatch countDownLatch;

	SecondThread(CountDownLatch countDownLatch) {

		this.countDownLatch = countDownLatch;
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println("SecondThread execution started with count down of 10 events...");

		for (int i = 0; i < 10; i++) {
			System.out.println("SecondThread count is " + i);
			countDownLatch.countDown();
		}
		System.out.println("Second thread CountDown is completed...");
	}

}

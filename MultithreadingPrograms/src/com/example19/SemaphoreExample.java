package example19;

import java.util.concurrent.Semaphore;

/*
 * @author vinayaknair
 *
 */
public class SemaphoreExample {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(1);

		new Incrementor("Thread-A", semaphore);
		new Decrementor("Thread-B", semaphore);
	}

}

class Shared {
	static int count = 0;
}

class Incrementor implements Runnable {

	String threadName;
	Semaphore semaphore;

	Incrementor(String threadName, Semaphore semaphore) {
		this.threadName = threadName;
		this.semaphore = semaphore;
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println(threadName + " is going to acquire Semaphore permit...");
		try {
			semaphore.acquire();
			System.out.println(threadName + " acquired semaphore...");
			for (int i = 1; i <= 10; i++) {
				Shared.count++;
				System.out.println(threadName + " count is: " + Shared.count);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(threadName + " going to release the permit...");
		semaphore.release();
	}
}

class Decrementor implements Runnable {

	String threadName;
	Semaphore semaphore;

	Decrementor(String threadName, Semaphore semaphore) {
		this.threadName = threadName;
		this.semaphore = semaphore;
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println(threadName + " is going to acquire Semaphore permit...");
		try {
			semaphore.acquire();
			System.out.println(threadName + " acquired semaphore...");
			for (int i = 1; i <= 10; i++) {
				Shared.count--;
				System.out.println(threadName + " count is: " + Shared.count);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(threadName + " going to release the permit...");
		semaphore.release();
	}
}
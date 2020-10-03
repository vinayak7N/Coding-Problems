package example9;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {

	public static void main(String[] args) {

		BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(10);
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		new Thread(producer).start();
		new Thread(consumer).start();
		System.out.println("Producer and Consumer has been started...");
	}
}

class Message {

	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getmessage() {
		return message;
	}
}

class Producer implements Runnable {
	private BlockingQueue<Message> blockingQueue;

	public Producer(BlockingQueue<Message> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			Message message = new Message("" + i);
			try {
				Thread.sleep(i);
				blockingQueue.put(message);
				System.out.println("Produced: " + message.getmessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Message message = new Message("exit");
		try {
			blockingQueue.put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Message> blockingQueue;

	public Consumer(BlockingQueue<Message> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			Message message;
			while (!(message = blockingQueue.take()).getmessage().equals("exit")) {
				Thread.sleep(10);
				System.out.println("Consumed: " + message.getmessage());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
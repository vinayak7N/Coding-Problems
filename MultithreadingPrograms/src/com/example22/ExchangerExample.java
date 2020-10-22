package example22;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {

		Exchanger<String> exchanger = new Exchanger<>();

		new StringCreator(exchanger);
		new StringConsumer(exchanger);
	}

}

class StringCreator implements Runnable {

	Exchanger<String> exchanger;
	String stringBuffer;

	StringCreator(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		stringBuffer = new String();
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println("String creation started...");

		char ch = 'A';

		// Number of times exchanges need to happen or create a string buffer 3 times
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				stringBuffer += ch++;
			}

			try {
				Thread.sleep(1000);

				// Exchange a full buffer with capital letters with small letters...
				stringBuffer = exchanger.exchange(stringBuffer);
				System.out.println("Inside creator: Exchanged String is::" + stringBuffer);
				stringBuffer = new String();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

class StringConsumer implements Runnable {
	Exchanger<String> exchanger;
	String stringBuffer;

	StringConsumer(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		stringBuffer = new String();
		new Thread(this).start();
	}

	@Override
	public void run() {

		System.out.println("String consumption started...");

		char ch = 'a';
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				stringBuffer += ch++;
			}
			try {
				Thread.sleep(1000);

				// Exchanging an small letters buffer with a capital letter one...
				stringBuffer = exchanger.exchange(stringBuffer);
				System.out.println("Inside consumer: Exchanged String is::" + stringBuffer);
				stringBuffer = new String();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

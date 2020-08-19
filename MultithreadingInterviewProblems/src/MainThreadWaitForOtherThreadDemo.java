/*   Program to show main thread waiting for a new child Thread to complete its execution.
 *
 * */
class ThreadDemo2 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MainThreadWaitForOtherThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        threadDemo2.start();
        threadDemo2.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}

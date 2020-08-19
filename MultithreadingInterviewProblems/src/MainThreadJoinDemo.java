/*   Program to show a new thread waiting for main Thread to complete its execution.
 *
 * */
class ThreadDemo extends Thread {

    static Thread mainThread;

    @Override
    public void run() {

        try {
            mainThread.join();  //This child thread will wait for main thread to complete its execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

public class MainThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo.mainThread = Thread.currentThread(); //Instance of main thread
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        threadDemo.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
            Thread.sleep(2000);
        }
    }
}

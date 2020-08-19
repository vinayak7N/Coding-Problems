/*   Program to show deadlock situation occurred due to main thread waiting for child thread and
 *   child thread is waiting for main thead to complete execution.
 * */
class ThreadDemo3 extends Thread {

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

public class ThreadDeadlockUsingJoin {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo3.mainThread = Thread.currentThread(); //Instance of main thread
        ThreadDemo3 threadDemo = new ThreadDemo3();
        threadDemo.start();
        threadDemo.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
            Thread.sleep(2000);
        }
    }
}

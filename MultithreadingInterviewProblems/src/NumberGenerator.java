public class NumberGenerator {

    private final int totalNumbersInSequence;
    private final int numberOfThreads;
    private int number = 1;

    public NumberGenerator(int numberOfThreads, int totalNumbersInSequence) {
        this.numberOfThreads = numberOfThreads;
        this.totalNumbersInSequence = totalNumbersInSequence;
    }

    public void printNumbers(int results) {
        synchronized (this) {
            while (number < totalNumbersInSequence - 1) {
                while (number % numberOfThreads != results) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number++);
                notifyAll();
            }
        }
    }
}

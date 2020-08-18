public class PrintNumberInSequenceUsingThreeThreads {

    /* Write a program to print number in sequence using 3 threads
     * Thread1   Thread2    Thread3
     *  1            2       3
     *  4            5       6
     *  7            8       9*/

    private static final int TOTAL_NUMBER_IN_SEQUENCE = 10;
    private static final int TOTAL_NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator(TOTAL_NUMBER_OF_THREADS, TOTAL_NUMBER_IN_SEQUENCE);
        Thread t1 = new Thread(new SequenceGenerator(numberGenerator, 1), "Thread-1");
        Thread t2 = new Thread(new SequenceGenerator(numberGenerator, 2), "Thread-2");
        Thread t3 = new Thread(new SequenceGenerator(numberGenerator, 0), "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}

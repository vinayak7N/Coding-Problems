package example15;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo[] callableDemos = {
                new CallableDemo(10),
                new CallableDemo(20),
                new CallableDemo(30),
                new CallableDemo(40),
                new CallableDemo(50),
                new CallableDemo(60),
                new CallableDemo(70),
                new CallableDemo(80)
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (CallableDemo callableDemo : callableDemos) {

            Future future = executorService.submit(callableDemo);
            System.out.println(future.get());
        }
        executorService.shutdown();
    }

}

class CallableDemo implements Callable {

    int num;

    CallableDemo(int num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {

        System.out.print(Thread.currentThread().getName() + " is calculating" +
                "the sum of first " + num + " numbers: ");
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}

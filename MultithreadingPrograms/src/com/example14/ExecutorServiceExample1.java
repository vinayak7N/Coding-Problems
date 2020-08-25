package example14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample1 {

    public static void main(String[] args) {

        PrintJob[] printJobs = {
                new PrintJob("Writing"),
                new PrintJob("Cleaning"),
                new PrintJob("Reading"),
                new PrintJob("Listening"),
                new PrintJob("Copying"),
                new PrintJob("Deleting")
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (PrintJob job : printJobs) {
            executorService.submit(job);
        }
        executorService.shutdown();
    }
}

class PrintJob implements Runnable {

    String name;

    PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + "...Job started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "...Job completed by " + Thread.currentThread().getName());
    }
}

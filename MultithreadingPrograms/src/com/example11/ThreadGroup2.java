package example11;


public class ThreadGroup2 {

    public static void main(String[] args) {

        Thread[] mainThreadArray = new Thread[2];
        Thread.currentThread().getThreadGroup().enumerate(mainThreadArray);

        System.out.println("Number of threads in main group:");
        int i = 1;
        for (Thread t : mainThreadArray) {
            System.out.println(i + "\t" + t.getName());
            i++;
        }

        Thread[] systemThreadArray = new Thread[6];
        Thread.currentThread().getThreadGroup().getParent().enumerate(systemThreadArray);

        System.out.println("Number of threads in system group:");
        i = 1;
        for (Thread t : systemThreadArray) {
            System.out.println(i + "\t" + t.getName());
            i++;
        }

    }
}

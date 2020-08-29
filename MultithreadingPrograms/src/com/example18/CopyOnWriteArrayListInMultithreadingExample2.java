package example18;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*  Here in, demonstrated operation on CopyOnArrayList which created a separate
 *   copy of arraylist for each thread which wants to update its value and
 *   jvm will merge all updated value to original list internally.
 * */

public class CopyOnWriteArrayListInMultithreadingExample2 extends Thread {

    static CopyOnWriteArrayList<Character> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " adding elements to list...");
        for (int i = 65; i < 70; i++) {
            System.out.println("Element added: " + (char) i);
            copyOnWriteArrayList.add((char) i);
        }
        System.out.println();
        CopyOnWriteArrayListInMultithreadingExample2 thread = new CopyOnWriteArrayListInMultithreadingExample2();
        thread.start();
        Iterator<Character> iterator = copyOnWriteArrayList.iterator();

        System.out.println(Thread.currentThread().getName() + " iterating list...");
        while (iterator.hasNext()) {
            System.out.println("Element: " + iterator.next());
            Thread.sleep(2000);

            /*Remove operation is not allowed in CopyOnArrayList as it will throw
             * UnsupportedOperationException*/
            // iterator.remove();
        }
        System.out.println(copyOnWriteArrayList);
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " updating list...");
        System.out.println("Element added: F");
        copyOnWriteArrayList.add('F');
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " updating list...");
        System.out.println("Element added: G");
        copyOnWriteArrayList.add('G');
    }
}

package example17;

import java.util.ArrayList;
import java.util.Iterator;

/*  Here in, program we demonstrated how ConcurrentModificationException happens i.e. when one
 *   thread is iterating over collection if another threads try to modify the list then this exception
 *   is thrown.*/

public class CollectionConcurrentModificationException extends Thread {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        list.add(10);
        list.add(20);
        list.add(30);
        CollectionConcurrentModificationException thread = new CollectionConcurrentModificationException();
        thread.start();

        Iterator<Integer> iterator = list.iterator();

        System.out.println("Main thread iterating over list....");
        while (iterator.hasNext()) {

            System.out.println("list element:" + iterator.next());
            Thread.sleep(3000);
        }

        System.out.println(list);

    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Child thread updating list....");
        list.add(24);
    }
}


package example18;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*  Here in , we are using two threads to update map value and no exception is thrown.
 *   Due to ConcurrentHashMap, it allows multiple thread to update object in thread safe manner.
 * */

public class ConcurrentHasMapInMultithreadingExample2 extends Thread {

    static ConcurrentHashMap<Integer, Character> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        ConcurrentHasMapInMultithreadingExample2 thread = new ConcurrentHasMapInMultithreadingExample2();
        thread.start();
        map.put(5, 'E');
        map.put(6, 'F');
        map.put(7, 'G');

        Set<Integer> keySet = map.keySet();
        System.out.println("Main thread iterating...");
        for (Integer key : keySet) {
            System.out.println("Key:" + key + "\t" + map.get(key));
            Thread.sleep(1000);
        }
        System.out.println("Main thread iteration over...");
        System.out.println(map);
    }

    @Override
    public void run() {

        try {
            System.out.println("Child thread updating map value...");
            map.put(4, 'D');
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child thread updating map value...");
        map.put(8, 'H');

    }


}

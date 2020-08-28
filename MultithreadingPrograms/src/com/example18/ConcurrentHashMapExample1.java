package example18;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample1 {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(101, "Harry");
        concurrentHashMap.put(102, "Mary");
        concurrentHashMap.put(103, "Kate");
        concurrentHashMap.put(104, "Holly");

        /* This method will add value to map only if it's not present already.
         * */
        concurrentHashMap.putIfAbsent(102, "Dark");
        concurrentHashMap.putIfAbsent(101, "Blake");
        System.out.println(concurrentHashMap);

        concurrentHashMap.remove(102);

        /* This method checks for both key, value pair before removing
         * */
        concurrentHashMap.remove(103, "Kate");

        /*This method take argument key, oldValue and newValue for replacement.
         * */
        concurrentHashMap.replace(101, "Harry", "Kerry");

        System.out.println(concurrentHashMap);

    }
}

package example18;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample1 {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);
        copyOnWriteArrayList.add(5);
        copyOnWriteArrayList.add(6);
        System.out.println(copyOnWriteArrayList);

        copyOnWriteArrayList.addIfAbsent(3);
        copyOnWriteArrayList.addIfAbsent(6);
        copyOnWriteArrayList.addIfAbsent(7);
        System.out.println(copyOnWriteArrayList);

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList2.add(5);
        copyOnWriteArrayList2.add(6);
        copyOnWriteArrayList2.add(7);
        copyOnWriteArrayList2.addIfAbsent(8);
        copyOnWriteArrayList2.addAll(copyOnWriteArrayList);
        System.out.println(copyOnWriteArrayList2);
    }
}

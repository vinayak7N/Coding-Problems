import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RearrangeDigitsToProduceMaxNumber {

    public static int sortDesc(final int num) {
        if (num <= 0)
            return num;

        ArrayList<Integer> arrayList = extractNum(num);
        String outNum = "";
        for (int i : arrayList) {
            outNum += i;
        }
        return Integer.parseInt(outNum);
    }

    private static ArrayList<Integer> extractNum(int num1) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (num1 > 0) {
            int last = num1 % 10;
            num1 = num1 / 10;
            arrayList.add(last);
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static int sortDescSecondWay(final int num) {

        return Integer.parseInt(String.valueOf(num)
                .chars().mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

    public static void main(String[] args) {
        System.out.println(sortDescSecondWay(123456789));
    }
}
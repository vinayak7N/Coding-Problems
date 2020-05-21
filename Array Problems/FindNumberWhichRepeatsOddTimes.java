import java.util.HashMap;

public class FindNumberWhichRepeatsOddTimes {

    public static int findIt(int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Integer c = map.get(a[i]);
            if (c != null) {
                map.put(a[i], c + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        int odd = 0;
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) % 2 != 0) {
                odd = a[i];
                break;
            }
        }
        return odd;
    }

    public static int findItSecondWay(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(findItSecondWay(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));

    }
}
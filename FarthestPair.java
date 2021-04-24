import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarthestPair {
    public static List<Integer> farthestPair(int[] vec) {
        Arrays.sort(vec);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int j : vec) {
            if (j < min) min = j;
            if (j > max) max = j;
        }

        int finalMin = min;
        int finalMax = max;
        return new ArrayList<Integer>(){
            {
                add(finalMin);
                add(finalMax);
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>(){
            {
                add(10);
                add(8);
                add(15);
                add(11);
                add(20);
                add(22);
                add(26);
                add(29);
                add(70);
                add(90);
                add(100);
                add(2);
            }
        };

        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = numbers.get(i);
        }
        farthestPair(a).forEach(System.out::println);
    }
}
 
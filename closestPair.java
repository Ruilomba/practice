import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class closestPair {
    public static List<Integer> closestPair(int[] vec) {
        Arrays.sort(vec);
        int a = 0;
        int b = 0;
        int closest = Integer.MAX_VALUE;
        for(int i = 1; i < vec.length; i++){
            int diff = Math.abs(vec[i-1] - vec[i]);
            if(diff < closest){
                closest = diff;
                a = i-1;
                b = i;
            }
        }
        int finalA = a;
        int finalB = b;
        return new ArrayList<Integer>(){
            {
                add(vec[finalA]);
                add(vec[finalB]);
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
        closestPair(a).forEach(System.out::println);
    }
}
 
import java.util.*;

public class FindMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0) return 0;
        return findMaxFormRec(strs, m, n, 0);
    }

    private static int findMaxFormRec(String[] strs, int zeroes, int ones, int index) {
        if(strs.length == index || zeroes + ones == 0) return 0;

        int currentZeroes = (int)strs[index].chars().filter( x -> x == '0').count();
        int currentOnes = (int)strs[index].chars().filter( x -> x == '1').count();

        int consider = 0;
        if(currentZeroes <= zeroes && currentOnes <= ones) consider = 1 + findMaxFormRec(strs, zeroes - currentZeroes, ones - currentOnes, index + 1);

        int skip = findMaxFormRec(strs, zeroes, ones, index + 1);

        return Math.max(skip, consider);

    }

    public static void main(String[] args) {
        String[] strings = new String[]{"10","0","1"};
        int test = findMaxForm(strings, 1, 1);
        strings = new String[]{"11111","100","1101","1101","11000"};
        test = findMaxForm(strings, 5, 7);
        strings = new String[]{"10","0001","111001","1","0"};
        test = findMaxForm(strings, 5, 3);
    }
}
 
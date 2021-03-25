import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class BinarySearchSpecial {
    public static boolean binarySearchFirstIndexOf(int[] a, int num) {
        if(a == null){
            return false;
        }

        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){

            int middle = (lo + hi) / 2;
            if(num < a[middle])
                hi = middle - 1;
            else if(num > a[middle])
                lo = middle + 1;
            else{
                if(middle == 0 || a[middle - 1] != num)
                    return true;
                lo = lo == 0 ? 0 : lo - 1;
                hi = hi == a.length - 1 ? a.length - 1 : hi + 1;
                while(lo <= hi){
                    middle = (lo + hi) / 2;

                    if(num == a[middle] && a[middle - 1] != num)
                        return true;
                    else if(num == a[middle]){
                        hi = middle - 1;
                    }else if(num != a[middle]){
                        lo = middle + 1;
                    }
                }
            }

        }

        return false;
    }


    public static void main(String[] args)   {
        boolean teste = binarySearchFirstIndexOf(new int[]{1,2,3,4,4,4,4,4,5,6,7,7,7,7,7,7,8}, 7);
    }
}
 